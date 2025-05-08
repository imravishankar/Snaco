package Snaco;

import Data.DataReader;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RegistrationPageTest extends BaseTest{

	@Test(dataProvider = "getDatas")
	public void RegistrationValidationTest(HashMap<String, String> input) throws IOException, InterruptedException {
		landingPage.newRegistration();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.completeRegistration(
				input.get("firstName"),
				input.get("lastName"),
				input.get("email"),
				input.get("phone"),
				input.get("occupation"),
				input.get("gender"),
				input.get("password"),
				input.get("confirmPwd")
		);
}

	@DataProvider
	public Object[][] getDatas() throws IOException {

		HashMap<String, String> map = new HashMap<String, String>();

		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap("src/test/java/Data/Registration.json");

		Object[][] dataArray = new Object[data.size()][1];
		for (int i = 0; i < data.size(); i++) {
			dataArray[i][0] = data.get(i);
		}
		return dataArray;
	}
}

