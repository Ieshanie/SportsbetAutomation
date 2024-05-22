package com.sportsbet.automationframework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sportsbet.automationframework.base.TestBase;
import com.sportsbet.automationframework.pages.HomePage;
import com.sportsbet.automationframework.util.TestUtil;

public class HomePageTest extends TestBase {
	WebDriver driver;
	SoftAssert sa;
	HomePage objHomePage;
	private static ExtentReports extent;
	private static ExtentTest test;

	@BeforeTest
	public void setup() {
		initialization();
		driver = super.driver;
		sa = new SoftAssert();
		objHomePage = new HomePage(driver);

		// Initialize Extent Report
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test
	public void verifyHomePageTitle() {
//		String HomePageTitle = objHomePage.verifyHomePageTitle();
//		sa.assertEquals(HomePageTitle, "Best Online Horse Racing and Sports Betting | Sportsbet");

		test = extent.createTest("verifyHomePageTitle");
		test.log(Status.INFO, "Navigating to the home page");
		String HomePageTitle = objHomePage.verifyHomePageTitle();
		test.log(Status.INFO, "Verifying the home page title");
		sa.assertEquals(HomePageTitle, "Best Online Horse Racing and Sports Betting | Sportsbet");

	}

	@Test(priority = 2)
	public void verifyRacingPage() {
		test = extent.createTest("verifyRacingPage");
		test.log(Status.INFO, "Clicking on the Racing tab");
		objHomePage.clickOnRacingTab();
		test.log(Status.INFO, "Verifying the Racing page");
		sa.assertTrue(objHomePage.verifyRacingPage(), "The Racing Tab is not selected");

	}

	@Test(priority = 3)
	public void selectFirstCardUnderNextToJump() {
		test = extent.createTest("selectFirstCardUnderNextToJump");
		test.log(Status.INFO, "Selecting the first card under Next to Jump");
		objHomePage.selectFirstCardUnderNextToJump();
		String screenshotPath = TestUtil.captureScreenshot(driver, "NextToJumpCarousel");
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Test(priority = 4)
	public void selectTwoBetsTotheBetSlip() {
        test = extent.createTest("selectTwoBetsTotheBetSlip");
        test.log(Status.INFO, "Selecting two bets to the bet slip");
        objHomePage.selectTwoBetsTotheBetSlip();
	}

	@Test(priority = 5)
	public void verifyBetCountInBetSlip() {
		test = extent.createTest("verifyBetCountInBetSlip");
		test.log(Status.INFO, "Clicking on the bet slip");
		objHomePage.clickOnBetSlip();
		test.log(Status.INFO, "Verifying the count of bets in the bet slip");
		int cardCount = objHomePage.betCountInBetSlip();
		sa.assertEquals(2, cardCount, "The number of 'betslip-single-' cards is not 2");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());
		} else {
			test.log(Status.PASS, "Test passed");
		}

		sa.assertAll();
		extent.flush();
	}

	@AfterTest
	public void tearDown() {
		sa.assertAll();
		// Driver Quit
		driver.quit();
	}
}
