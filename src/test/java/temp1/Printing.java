package temp1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Printing {

	public static void main(String args[])
	{
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.close();
	}
	
}
