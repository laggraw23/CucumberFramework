package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	private static WebDriverWait waitDriver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	private FileInputStream fis;

	//private constructor so nobody can create the object of this class
	private SeleniumDriver() {
		try {
			fis = new FileInputStream("./src/main/resources/properties/OR.properties");
			OR.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/main/resources/properties/Config.properties");
			config.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (config.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

	}
	
	//getter
	public static WebDriver getDriver() {
		return driver;
	}
	
	//setter
	public static void setupDriver() {
		if(seleniumDriver == null) {
			seleniumDriver = new SeleniumDriver();	
		}
		
	}
	
	
	public static void openPage(String url) {
		driver.get(url);
	}
	
	
	public static void tearDown() {
		
		if(driver != null) {
			driver.close();
			driver.quit();
		}
		
		seleniumDriver = null;
	}
	
}
