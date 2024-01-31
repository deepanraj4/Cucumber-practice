package org.steps;

import org.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Adactin01StepsClass extends BaseClass {
	
	@Given("user should be in adactin login page")
	public void user_should_be_in_adactin_login_page() {
	   try {
		   getDriver("Chrome");
		   getUrl("https://adactinhotelapp.com/");
		   System.out.println("Url launched successfully");
		
	} catch (Exception e) {
		System.out.println("url launch failed");
	}
	   
	}
	
	@When("user should enter the username and password")
	public void user_should_enter_the_username_and_password() {
		
		System.out.println("01");
	    
	}
	@Then("user have to click login button")
	public void user_have_to_click_login_button() {
		
		
		System.out.println("02");
	    
	}
	@Then("user should verify login successfull message")
	public void user_should_verify_login_successfull_message() {
		
		System.out.println("03");
	    
		
	}


}
