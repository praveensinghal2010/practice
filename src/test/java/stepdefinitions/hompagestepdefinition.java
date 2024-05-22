package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepage;

public class hompagestepdefinition {

	Homepage homepage;
	public WebDriver driver;
	TestContext context;

	public hompagestepdefinition(TestContext context) {
		this.context = context;
	}

	@Given("user is at bse india homepage")
	public void user_is_at_bse_india_homepage() {
		homepage = new Homepage(context.driver);
		homepage.testingmethod();
	}

	@When("user click on select language dropdown")
	public void user_click_on_select_language_dropdown() {
		homepage.clickonlanguage();
	}

	@Then("user is able to view below list of values")
	public void user_is_able_to_view_below_list_of_values(List<List<String>> language) {

		try {
			boolean flag = homepage.validatelistoflanguage(language);
			Assert.assertEquals(flag, true);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@When("usr select the language {string} from the dropdown")
	public void usr_select_the_language_from_the_dropdown(String lang) {

		try {
			homepage.clicloflanguage(lang);

		} catch (Exception e) {
			e.printStackTrace();
			

		}

	}

	@Then("user is navigated to the page translated in hindi")
	public void user_is_navigated_to_the_page_translated_in_hindi() {
		try {
			homepage.verifytitle();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	@Then("user is able to view below keys of values")
	public void user_is_able_to_view_below_keys_of_values(List<Map<String,String>> expectedmap) {
	   
		
		try {
			
		Map<String,String> acutalmap=homepage.verifymap();
		if(!acutalmap.equals(expectedmap.get(0)))
			Assert.fail();
		

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		}
	}
	
	@When("usr select the language {string} key from the dropdown")
	public void usr_select_the_language_key_from_the_dropdown(String key) {
		try {
			
		
			homepage.clickonmapkey(key);
			

			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();

			}
	}

	@Then("user is able to view indices table")
	public void user_is_able_to_view_indices_table(List<List<String>> indicestable) {
	  
		try {
			
			
		//	List<List<String>>actualtable=homepage.validateindicestable();
			

			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();

			}
	}
	}
	

