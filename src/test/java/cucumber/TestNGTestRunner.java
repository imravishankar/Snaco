package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", // path to your feature files

		glue = "stepDefinitions", // package containing step defs.
		monochrome = true, 
		dryRun = true

)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
