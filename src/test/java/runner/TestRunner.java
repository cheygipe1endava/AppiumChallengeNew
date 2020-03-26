package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"steps", "helper"},
                                plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"})
public class TestRunner {
}