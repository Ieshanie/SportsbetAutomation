package com.sportsbet.automationframework.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.sportsbet.automationframework.base.TestBase;
import com.sportsbet.automationframework.util.TestUtil;

public class HomePage extends TestBase {

	By racingTab = By.cssSelector("button[data-automation-id='racing-tab-switch-selected']");
	By firstItem = By.xpath("//div[@data-automation-id='group-3-list-1-body-container-row-1']/a");
	By nextToJumpCarousel = By.cssSelector("[data-automation-id='group-1-carousel-1-container']");
	By firstCard = By.cssSelector("div[data-automation-id='group-1-carousel-1-body-container-cell-1'] a");
	By marketButton = By.cssSelector("div[data-automation-id='racecard-price-button-deselected'] button");
	By closeButton = By.cssSelector("button[data-automation-id='betslip-header-hide']");
	By betSlip = By.cssSelector("button[data-automation-id='header-betslip-touchable']");
	By betSlipSingleCard = By.cssSelector("[data-automation-id^='betslip-single-']");

	// Initializing the Page Object
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Verify Home Page Title
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	// Click on Racing Page Tab
	public void clickOnRacingTab() {
		driver.findElement(racingTab).click();

	}

	// Verify Racing Page
	public boolean verifyRacingPage() {
		return driver.findElement(racingTab).isDisplayed();
	}

	// select First Card Under Next To Jump
	public void selectFirstCardUnderNextToJump() {

		// Use the utility method to wait for the next To Jump Carousel
		WebElement nextToJumpSectionElement = TestUtil.waitForElementVisibility(driver, nextToJumpCarousel, 30);

		// Select first card under the ‘Next to Jump’
		nextToJumpSectionElement.findElement(firstCard).click();
		

	}

	// Verify First Card Under Next To Jump
	public boolean VerifyFirstCardUnderNextToJump() {
		return driver.findElement(firstCard).isDisplayed();
	}

	public void selectTwoBetsTotheBetSlip() {
		// Find all the available bet buttons
		List<WebElement> betButtons = driver.findElements(marketButton);

		// Get the size of the list
		int numButtons = betButtons.size();

		// Create a list to store the indices of the selected buttons
		List<Integer> selectedIndices = new ArrayList<>();

		// Select two random indices
		while (selectedIndices.size() < 2) {
			int randomIndex = new Random().nextInt(numButtons);
			if (!selectedIndices.contains(randomIndex)) {
				selectedIndices.add(randomIndex);
			}
		}

		// Click the first selected button
		int firstIndex = selectedIndices.get(0);
		betButtons.get(firstIndex).click();

		// Find and click the close button after adding the first bet
		driver.findElement(closeButton).click();

		// Click the second selected button
		int secondIndex = selectedIndices.get(1);
		betButtons.get(secondIndex).click();

	}

	public void clickOnBetSlip() {
		driver.findElement(betSlip).click();
	}

	// Verify the Bet Slip isDisplayed
	public boolean verifyBetSlipIsOpened() {
		return driver.findElement(betSlip).isDisplayed();
	}

	public int betCountInBetSlip() {
		// Find all the 'betslip-single-' cards
		List<WebElement> betslipSingleCards = driver.findElements(betSlipSingleCard);

		// Get the count of 'betslip-single-' cards
		int cardCount = betslipSingleCards.size();
		return cardCount;
	}

}
