package com.sportsbet.automationframework.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sportsbet.automationframework.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	// Method to wait until an element is visible
	public static WebElement waitForElementVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public static String captureScreenshot(WebDriver driver, String fileName) {
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        String fileExtension = ".png";
        String screenshotName = fileName + "_" + timestamp + fileExtension;

        try {
            FileUtils.copyFile(srcFile, new File(screenshotPath + screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath + screenshotName;
    }

}
