package Snaco;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.DataReader;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();

		productCatalogue.addProductToCart(input.get("product"));

		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));

		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();

		Thread.sleep(2000);

		checkOutPage.selectCountry("india");

		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String ConfirmMessage = confirmationPage.getConfirmationMessage();

		AssertJUnit.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(ConfirmMessage);
		SignOut signOut = new SignOut(driver);
		signOut.signOut();
	}

	// To Verify ZARA COAT 3 displaying on Orders page.

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderHistoryTest() {

		ProductCatalogue productCatalogue = landingPage.loginApplication("ravishan1992@gmail.com", "#ravi@123");

		OrderPage orderPage = productCatalogue.goToOrdersPage();

		// orderPage.VerifyOrderDisplay(productName);
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		HashMap<String, String> map = new HashMap<String, String>();

		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap("src/test/java/Data/PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}

//@DataProvider
//public Object[][] getData() {
//
//	HashMap<String, String> map = new HashMap<String, String>();
//
//	map.put("email", "ravishan1992@gmail.com");
//	map.put("password", "#ravi@123");
//	map.put("product", "ADIDAS ORIGINAL");
//
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("email", "rv.shankar009@gmail.com");
//	map1.put("password", "#Iamking@000");
//	map1.put("product", "ZARA COAT 3");
//
//	return new Object[][] { { map }, { map1 } };
//}

// @DataProvider
// public Object[][] getData() {
//
// return new Object[][] { { "ravishan1992@gmail.com", "#ravi@123", "ADIDAS
// ORIGINAL" },
// { "rv.shankar009@gmail.com", "#Iamking@000", "ZARA COAT 3" } };
// }
