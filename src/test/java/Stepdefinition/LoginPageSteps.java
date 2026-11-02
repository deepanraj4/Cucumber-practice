package Stepdefinition;

import io.cucumber.java.en.And;
import PageObjects.LoginPageobjects;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.apache.poi.ss.usermodel.CellStyle;
import org.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import restassured.RestAssured;
//import restassured.http.Method;
//import restassured.response.Response;
//import restassured.specification.RequestSpecification;
//import org.json.simple.JSONObject;
//import org.junit.Assert;

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

	/*@Test
    public void tc01()
	{
		RestAssured.baseURI = "https://abc.in";
		RequestSpecification rs = RestAssured.given();
		rs.headers("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", 13344);
		jsonObject.put("type","mobiles");
		jsonObject.put("item", 5);
		rs.body(jsonObject.toJSONString());
		rs.auth.basic("username", "pass");
		Response res = rs.request(Method.POST, "url");
		int code = res.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 201);
		String body = res.getBody().asPrettyString();
		System.out.println(body);
		Assert.assertEquals("expected", res.jsonPath().get("jsonpath"));
	}*/

@Test
	public void FindBrokenlink() throws Exception {


	getDriver("Chrome");
	driver.get("https://www.airtelxstream.in/");

	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("total url " + links.size());

	List<String> urls = new ArrayList<>();
	for (WebElement link : links) {

		try {
			String href = link.getAttribute("href");
			if (href != null && !href.trim().isEmpty()) {
				urls.add(href.trim());
			}
		} catch (StaleElementReferenceException e) {
			// element disappeared, just skip it
		}
	}

	// Step 2: verify each URL using only Strings
	int broken = 0;
	for (String url : urls) {

		// Step 3: skip non-HTTP links
		if (!url.startsWith("http")) {
			System.out.println("Skipped: " + url);
			continue;
		}
		try {
			URL linkUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
			connection.setRequestMethod("HEAD");//An HTTP HEAD request asks the server for response headers without requesting the response body.
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int responseCode = connection.getResponseCode();

			if (responseCode >= 400) {

				System.out.println("Bad URL > response Code " + responseCode + "\n" + " Bad URL link : " + url);

			} else {

				System.out.println("Good URL > response Code " + responseCode + "\n" + "  Good URL link : " + url);

			}

			connection.disconnect();
		} catch (Exception e) {

			System.out.println("unnable to verify the link" + url + "Reason : " + e.getMessage());
		}
	}
	driver.quit();
}
}
