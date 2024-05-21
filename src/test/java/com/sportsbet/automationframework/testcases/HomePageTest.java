package com.sportsbet.automationframework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sportsbet.automationframework.base.TestBase;
import com.sportsbet.automationframework.pages.HomePage;

public class HomePageTest extends TestBase {
	WebDriver driver;
	SoftAssert sa;
	HomePage objHomePage;

	@BeforeTest
	public void setup() {
		initialization();
		driver = super.driver;
		sa = new SoftAssert();
		objHomePage = new HomePage(driver);
	}

	@Test
	public void verifyHomePageTitle() {
		String HomePageTitle = objHomePage.verifyHomePageTitle();
		sa.assertEquals(HomePageTitle, "Best Online Horse Racing and Sports Betting | Sportsbet");

	}

	@Test(priority = 2)
	public void verifyRacingPage() {
		objHomePage.clickOnRacingTab();
		//Verify the Racing Tab is selected
	   sa.assertTrue(objHomePage.verifyRacingPage(), "The Racing Tab is not selected");
		
	}

	@Test(priority = 3)
	public void selectFirstCardUnderNextToJump() {
		objHomePage.selectFirstCardUnderNextToJump();
		
		//Verify the Next to Jump Carousel is displayed
		//sa.assertTrue(objHomePage.VerifyFirstCardUnderNextToJump(), "The Next to Jump Carousel is not displayed");
	}

	@Test(priority = 4)
	public void selectTwoBetsTotheBetSlip() {
		objHomePage.selectTwoBetsTotheBetSlip();
		//  sa.assertTrue(objHomePage.verifyBetSlipIsOpened(), "The Bet Slip is not displayed");
	}

	@Test(priority = 5)
	public void verifyBetCountInBetSlip() {
		objHomePage.clickOnBetSlip();
		int cardCount = objHomePage.betCountInBetSlip();
		// Assert that the card count is 2
		sa.assertEquals(2, cardCount, "The number of 'betslip-single-' cards is not 2");
	}

	@AfterTest
	public void tearDown() {
		sa.assertAll();
		//Driver Quit
		driver.quit();
	}
}
