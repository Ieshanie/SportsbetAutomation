package com.sportsbet.automationframework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sportsbet.automationframework.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	public static Properties prop;

	public TestBase() {
		//
		try {
			// Create object of property file
			prop = new Properties();
			
			// create object of file FileInputStream
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/sportsbet/automationframework/config/config.properties");
			prop.load(ip);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Initialization
	public void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			// Initialize the ChromeDriver
			driver = new ChromeDriver();
			
			// Set the browser window size to 420 pixels
			
	        driver.manage().window().setSize(new Dimension(420, driver.manage().window().getSize().height));

			
			//Delete All Cookies
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			
			// Open a website
			driver.get(prop.getProperty("url"));

		}
	}

}
