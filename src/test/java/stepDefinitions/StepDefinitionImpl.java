package stepDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{

	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("Logged in with username ravishan1992@gmail.com and password #ravi@{int}")
	public void logged_in_with_username_ravishan1992_gmail_com_and_password_ravi(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I add product ZARA COAT {int} from cart")
	public void i_add_product_zara_coat_from_cart(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("Checkout ZARA COAT {int} and submit the order")
	public void checkout_zara_coat_and_submit_the_order(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I verify {string} message displayed on confirmationpage")
	public void i_verify_message_displayed_on_confirmationpage(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("Logged in with username <username> and password #ravi@{int}")
	public void logged_in_with_username_username_and_password_ravi(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("{string} message displayed.")
	public void message_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
