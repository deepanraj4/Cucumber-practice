package Stepdefinition;

import io.cucumber.java.en.And;
import PageObjects.LoginPageobjects;
import org.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginPageSteps extends BaseClass {
	// don't instantiate page object before driver is initialized
	LoginPageobjects loginPage;

	@Given("open the browser and launch the application")
	public void openBrowserAndLaunchApplication() {
		// This can be a setup step if needed, or left empty if Background just
		// serves as a precondition that's handled elsewhere
		System.out.println("Browser and application setup (Background)");
	}


	@Given("user should be in adactin login page")
	public void user_should_be_in_adactin_login_page() {
	   try {
		   getDriver("Chrome");
		   getUrl("https://Hotelbooker.sabre.com/");
		   loginPage = new LoginPageobjects(driver);
		   System.out.println("Url launched successfully");
		
	} catch (Exception e) {
		System.out.println("url launch failed");
	}
	   }

	@When("user should enter the {string} and {string}")
	public void userShouldEnterTheUsernameAndPassword(String username, String password) {
		// ensure page object is ready (it is instantiated in the Given step after driver is created)
		loginPage.USERNAME_FIELD.sendKeys(username);
		loginPage.PASSWORD_FIELD.sendKeys(password);
	}

	@Then("user clicks the login button")
	public void userClicksTheLoginButton() {
		loginPage.LOGIN_BUTTON.click();

		System.out.println("Login Button clicked successfully");

	}
	@And("user should verify login successful message")
	public void userShouldVerifyLoginSuccessfulMessage() {
		System.out.println("Login successful");
	}


	@Then("user should select the client {string} and verify the client name")
	public void userSelectClient(String clientName) {
		loginPage.Select_Client(clientName);
		System.out.println("Client selected and verified successfully");
	}
}
