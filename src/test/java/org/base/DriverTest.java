package org.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverTest  {
public static void main(String[] args) {
	
	System.setProperty("webdriver.Chrome.driver","C:\\Users\\Deepanraj\\eclipse-workspace\\FrameworkAdactin\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	
	
}
}