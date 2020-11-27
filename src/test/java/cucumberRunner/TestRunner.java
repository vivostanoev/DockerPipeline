package cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefenition")
public class TestRunner extends AbstractTestNGCucumberTests {
}
