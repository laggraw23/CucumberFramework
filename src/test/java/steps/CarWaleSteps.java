package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Base.BasePage;
import page.Objects.HomePage;
import page.Objects.NewCarsPage;
import utils.SeleniumDriver;

public class CarWaleSteps {

	HomePage home = new HomePage();
	NewCarsPage car ;

	
	
	@Given("user navigate to carwale website")
	public void user_navigate_to_carwale_website() throws InterruptedException {

		SeleniumDriver.openPage(SeleniumDriver.config.getProperty("testingurl"));
	}

	@When("User mouseover to newcars")
	public void user_mouseover_to_newcars() {

		home.mouseOverNewCars();
	}

	@Then("user click on Findnewcars")
	public void user_click_on_findnewcars() {

		car = home.clickFindNewCars();
	}

	@And("user clicks on {string} Car")
	public void user_clicks_on_car(String brand) {

		if(brand.equals("Toyota")) {
			car.gotoToyota();	
		}
		else if(brand.equals("BMW")) {
			car.gotoBMW();
		}
		else if(brand.equals("KIA")) {
			car.gotoKia();
		}
//		else if(brand.equals("HONDA")) {
//			car.gotoHonda();
//		}
	    
	}

	@And("user validates carTitle as {string}")
	public void user_validates_car_title(String carTitle) {
//		System.out.println("Inside And user validates carTitle as "+carTitle+" cars");
		
		System.out.println("Car Title is : "+ BasePage.carBase.getCarTitle());
		Assert.assertTrue(BasePage.carBase.getCarTitle().equals(carTitle));
	}


}
