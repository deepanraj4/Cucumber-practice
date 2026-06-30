package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature\\Testing.feature",
        glue="Stepdefinition",
        tags = "@Loginpage",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"})
public class TestRunner {

	
	
}
