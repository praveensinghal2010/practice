package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunnerTest {

	@CucumberOptions(
			plugin= {"pretty","html:target/abc.html"},
			features="src/test/resources/features",
			glue= {"stepdefinitions","hooks"},
			dryRun=false,
			tags="@sanity6")
	
	
	public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}
}
