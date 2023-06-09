package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features//"},
                 glue = "StepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = {"html:reports/cucumber-report.html",
                		 "json:reports/cucumber-report.json"})
public class TestRunner {

}
