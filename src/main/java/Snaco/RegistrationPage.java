package Snaco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class RegistrationPage extends AbstractComponent {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userMobile")
    WebElement userMobile;

    @FindBy(css = "select[formcontrolname='occupation']")
    WebElement occupationDropdown;

    @FindBy(css = "input[value='Male']")
    WebElement maleGender;

    @FindBy(css = "input[value='Female']")
    WebElement femaleGender;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(css = "input[formcontrolname='required']")
    WebElement ageCheckbox;

    @FindBy(id = "login")
    WebElement registerButton;

    public void completeRegistration(String fName,String lName,String email,String phone,String occupation,String gender,String password,String confirmPwd) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userEmail.sendKeys(email);
        userMobile.sendKeys(phone);
        selectOccupation(occupation);
        selectGender(gender);
        userPassword.sendKeys(password);
        confirmPassword.sendKeys(confirmPwd);
        if (!ageCheckbox.isSelected()) {
            ageCheckbox.click();
        }
        registerButton.click();
    }
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            maleGender.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            femaleGender.click();
        }
    }
    public void selectOccupation(String occupation) {
        Select select = new Select(occupationDropdown);
        select.selectByVisibleText(occupation);
    }

}
