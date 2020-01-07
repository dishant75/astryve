package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.IllustrationListingLocators;
import com.finablr.admin.utilities.Common;

public class IllustrationListingWrapper {
	
	
	WebDriver driver;
	String Actual_Pagetitle="Configuration Management";
	String Actual_IlluTitle="Illustration Management";
	String Actual_EventName="Thank you";
	String pagetitle,illustrationTitle,eventname;
	public static Logger log = LogManager.getLogger(IllustrationListingWrapper.class);
	
	public IllustrationListingWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=IllustrationListingLocators.Configuration_LeftSide)
	WebElement configLeft;
	
	@FindBy(xpath=IllustrationListingLocators.IllustartionPage)
	WebElement illuPage;
	
	@FindBy(xpath=IllustrationListingLocators.ConfigPageTitle)
	WebElement configtitle;
	
	
	public void navigateIllustrationPage()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, configLeft);
		Common.clickableElement(configLeft, driver);
		Common.clickOn(driver, configLeft);
		Common.pause(2);
		Common.waitForElement(driver, configtitle);
		pagetitle=configtitle.getText().trim();
		System.out.println("Cofig Page title is: "+pagetitle);
		Assert.assertTrue(pagetitle.equalsIgnoreCase(Actual_Pagetitle), "Config title Doesn't Match");
		Common.waitForElement(driver, illuPage);
		Common.clickableElement(illuPage, driver);
		Common.clickOn(driver, illuPage);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=IllustrationListingLocators.IllustrationPage_title)
	WebElement illuPageTitle;
	
	@FindBy(xpath=IllustrationListingLocators.SearchBox)
	WebElement searchbx;
	
	@FindBy(xpath=IllustrationListingLocators.Get_eventname)
	WebElement geteventname;
	
	
	public void illustartionListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, illuPageTitle);
		illustrationTitle=illuPageTitle.getText().trim();
		System.out.println("Illustration Page Title is: "+illustrationTitle);
		Common.waitForElement(driver, searchbx);
		Common.clickableElement(searchbx, driver);
		Common.clickOn(driver, searchbx);
		searchbx.sendKeys(Actual_EventName);
		searchbx.sendKeys(Keys.ENTER);
		Common.pause(2);
		Common.waitForElement(driver, geteventname);
		eventname=geteventname.getText().replace("Event: ","").trim();
		System.out.println("Event name is: "+eventname);
		Assert.assertTrue(eventname.equalsIgnoreCase(Actual_EventName),"Event name doesn't match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
