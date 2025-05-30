package Snaco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	@FindBy(css=".btn1")
	WebElement registerButton;
	
	public ProductCatalogue loginApplication(String email,String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");

	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void newRegistration() {

		registerButton.click();
	}
}
