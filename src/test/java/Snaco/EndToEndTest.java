package Snaco;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EndToEndTest {

	public static void main(String[] args) throws InterruptedException {

		String productName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("userEmail")).sendKeys("ravishan1992@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("#ravi@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cartProducts.stream()
				.anyMatch(cartroduct -> cartroduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);// match
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".totalRow button")));

		WebElement Submit = driver.findElement(By.cssSelector(".totalRow button"));

		js.executeScript("arguments[0].click();", Submit);

		WebElement country = driver.findElement(By.cssSelector("[placeholder='Select Country']"));

		Actions a = new Actions(driver);

		a.sendKeys(country, "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));

		WebElement enter = driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]"));

		js.executeScript("arguments[0].click();", enter);

		WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));

		js.executeScript("arguments[0].click();", placeOrder);
		String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		WebElement signOut = driver.findElement(By.xpath("//*[contains(@class,'sign-out')]"));
		js.executeScript("arguments[0].click();", signOut);

		driver.quit();
	}

}
