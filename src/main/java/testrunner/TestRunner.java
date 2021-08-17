package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/feature",
                glue = {"stepdefinition"},
                tags = "@Smoke or @Sanity",
                plugin = {"pretty","html:target/cucumber-reports.html", "json:target/json-reports.json"},
                dryRun = false


              )
public class TestRunner {
    
}