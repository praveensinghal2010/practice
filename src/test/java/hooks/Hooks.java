package hooks;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

	public WebDriver driver;
	public TestContext context;
	
	

	public Hooks(TestContext context) {
		this.context=context;
	}

	@Before
	public void webdriversetup() {
		driver = DriverFactory.intializedriver();
		context.driver = this.driver;
		
		
		
	}

	@After
	public void quitdriver(Scenario scenario) {
		
	if(scenario.isFailed())
	{
		TakesScreenshot sh= (TakesScreenshot) driver;
		byte[] screenshot = sh.getScreenshotAs(OutputType.BYTES);
        // Embed screenshot in the report
        scenario.attach(screenshot, "image/png", "FailureScreenshot");
	}
		
		
		driver.quit();
	}
}