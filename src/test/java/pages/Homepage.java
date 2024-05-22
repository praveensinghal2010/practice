package pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



public class Homepage extends BasePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div[4]/div/div[2]/div[2]/div/button")
	WebElement selectlanguage;
	
	public Homepage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
	}

	public void testingmethod()
	{
		
	}
	
	public void clickonlanguage()
	{
		wait.until(ExpectedConditions.visibilityOf(selectlanguage)).click();
	}
	
	public boolean validatelistoflanguage(List<List<String>> language)
	{
		List<String> languagetext=language.get(0);
		List<WebElement> elements=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
		List<String> elementstext=elements.stream().map(element->element.getText().toString()).collect(Collectors.toList());
		boolean flag=languagetext.equals(elementstext);
		return flag;
	}
	
	public void clicloflanguage(String lang)
	{
		List<WebElement> elementsnew=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
		elementsnew.stream().filter(element->element.getText().equals(lang)).findFirst().ifPresent(WebElement::click);
	}
	
	public void verifytitle()
	{
		String acutaltitie=null;
		String expectedtitle="Bombay Stock Exchange - BSE Hindi site for SENSEX, stock quotes and market trend";		String handle= driver.getWindowHandle();
		Set<String> handles= driver.getWindowHandles();
		for(String hand: handles)
		{
			if(!hand.equals(handle))
			{
				driver.switchTo().window(hand);
				acutaltitie=driver.getTitle();
				driver.close();
				driver.switchTo().window(handle);
			}
		}
		Assert.assertEquals(expectedtitle,acutaltitie);
	}
	
	public Map<String,String> verifymap()
	{
		List<WebElement> elements=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
		List<WebElement> elementskey=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
		Map<String,String> actualmap= new HashMap<>();
		for(int i=0; i<elements.size(); i++)
		{
			actualmap.put(elements.get(i).getText().toString(), elementskey.get(i).getText().toString());
		}
		return actualmap;
	}
	
	public void clickonmapkey(String key)
	{
		List<WebElement> elements=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
		List<WebElement> elementskey=driver.findElements(By.xpath("//ul[@class='dropdown-menu show']/li"));
		Map<String,String> actualmap= new HashMap<>();
		for(int i=0; i<elements.size(); i++)
		{
			actualmap.put(elements.get(i).getText().toString(), elementskey.get(i).getText().toString());
		}
		
		List<List<WebElement>> abc= new ArrayList<>();
		Optional<WebElement> optional;
	    for(List<WebElement> first : abc)
	    {
	    	 optional= first.stream().filter(a->a.getText().contains("abc")).findFirst();
	    	// if(optional.isPresent())
	    }
	
		
	}
	

	
	
}
		
	 //   List<String> abc= actualmap.entrySet().stream().filter(a->a.getKey().equals("hindi")).collect(Collectors.toList());)
	//}
	//Extracting Text from Elements:
	/*
	 * List<WebElement> elements = driver.findElements(By.tagName("p"));
	 * List<String> texts =
	 * elements.stream().map(WebElement::getText).collect(Collectors.toList());
	 * 
	 * 
	 * //Filtering Elements by Attribute: WebElement dropdown =
	 * driver.findElement(By.id("dropdown")); List<WebElement> options =
	 * dropdown.findElements(By.tagName("option")); List<String> optionTexts =
	 * options.stream().map(WebElement::getText).collect(Collectors.toList());
	 * 
	 * 
	 * //Searching for Specific Text in Elements: List<WebElement> elements =
	 * driver.findElements(By.tagName("div")); Optional<WebElement> foundElement =
	 * elements.stream().filter(element ->
	 * element.getText().contains("searchText")).findFirst();
	 * 
	 * 
	 * //Extracting Table Data: WebElement table =
	 * driver.findElement(By.tagName("table")); List<List<String>> tableData =
	 * table.findElements(By.tagName("tr")).stream() .map(row ->
	 * row.findElements(By.tagName("td")).stream() .map(WebElement::getText)
	 * .collect(Collectors.toList())) .collect(Collectors.toList()); //Handling
	 * Checkboxes:
	 * 
	 * List<WebElement> checkboxes =
	 * driver.findElements(By.xpath("//input[@type='checkbox']"));
	 * checkboxes.stream().filter(WebElement::isSelected).forEach(WebElement::click)
	 * ;
	 * 
	 * List<WebElement> checkboxes =
	 * driver.findElements(By.xpath("//input[@type='checkbox']"));
	 * checkboxes.stream().filter(WebElement::isSelected).findfirst().isPresent(
	 * WebElement::click); }
	 * 
	 */