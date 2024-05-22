package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigLoader;

public class DriverFactory {

	
	public static WebDriver intializedriver()
	{
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ConfigLoader.getInstance().getProperty("baseurl"));;
		return driver;
	}
	
	
	

}
