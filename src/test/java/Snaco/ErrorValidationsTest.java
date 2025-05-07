package Snaco;

import TestComponents.BaseTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;
public class ErrorValidationsTest extends BaseTest{
	
	@Test(groups= {"ErrorHandaling"},retryAnalyzer=TestComponents.Retry.class)
	public void Loginerrorvalidation() {
		

		landingPage.loginApplication("ravishan1992@gmail.com", "@ravi@123");

		landingPage.getErrorMessage();
		
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void ProductErrorvalidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("rv.shankar009@gmail.com", "#Iamking@000");

		List<WebElement> products = productCatalogue.getProductList();

		productCatalogue.addProductToCart(productName);

		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");

		Assert.assertFalse(match);

	}
}
