package Snaco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	By submit = By.cssSelector(".totalRow button");
	public Boolean VerifyProductDisplay(String productName) {

		Boolean match = productTitles.stream()
				.anyMatch(cartroduct -> cartroduct.getText().equalsIgnoreCase(productName));
		return match;

	}

	public CheckOutPage goToCheckOut() {

		waitForElementToAppear(submit);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkoutEle);
		//checkoutEle.click();
		return new CheckOutPage(driver);
	}
}
