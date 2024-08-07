package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.SeleniumDriver;

public class Hooks {

	public WebDriver driver;

	@Before
	public void setup() {
		System.out.println("Inside Hooks: Setup");
		SeleniumDriver.setupDriver();
	}

	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		System.out.println("Inside Hooks: TearDown");
		
		if (scenario.isFailed()) {
			driver = SeleniumDriver.getDriver();
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot_" + scenario.getName());
		}

		Thread.sleep(Duration.ofSeconds(3));
		SeleniumDriver.tearDown();
	}

}
