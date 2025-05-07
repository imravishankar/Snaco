package Snaco;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Test {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://snacgo.com/test");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions a = new Actions(driver);

		WebElement draggable = driver.findElement(By.className("draggable"));
		WebElement dropzone = driver.findElement(By.className("dropzone"));

		a.dragAndDrop(draggable, dropzone).build().perform();
		WebElement twitter = driver.findElement(By.cssSelector(".fab.fa-twitter"));
		a.keyDown(Keys.CONTROL).click(twitter).build().perform();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parentid = it.next();
		String childid = it.next();

		driver.switchTo().window(childid);

		String title = driver.getTitle();
		System.out.println("Child Window Title : "+title);
		Assert.assertEquals("SnacGO", title);

		driver.switchTo().window(parentid);
		String title2 = driver.getTitle();
		System.out.println("Parent Window Title : "+title2);
		Assert.assertEquals("SnacGO", title2);
		
		WebElement cart = driver.findElement(By.xpath("//*[contains(@class,'cart-shopping')]"));
		
		cart.click();
		String msg = driver.findElement(By.xpath("//span[text()='Empty cart']")).getText();
		
		System.out.println(msg);
		
		Assert.assertEquals("Empty cart", msg);
		
		driver.quit();
	}

}
