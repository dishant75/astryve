package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AppUsersListingLocators;
import com.finablr.admin.utilities.Common;

public class AppUserListingWrapper {
	
	WebDriver driver;
	String Actual_Email="kim.john688@yopmail.com";
	String get_email;
	public static Logger log = LogManager.getLogger(SubAdminListingWrapper.class);
	
	public AppUserListingWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	
	@FindBy(xpath=AppUsersListingLocators.App_User )
	WebElement appuserLink;
	
	@FindBy(xpath=AppUsersListingLocators.Select_Filter)
	WebElement selectfilter;
	
	@FindBy(xpath=AppUsersListingLocators.Search)
	WebElement searchbox;
	
	@FindBy(xpath=AppUsersListingLocators.Get_EmailAddress)
	WebElement getEmail;
	
	public void searchUser()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Common.waitForElement(driver, appuserLink);
		Common.clickableElement(appuserLink, driver);
		Common.clickOn(driver, appuserLink);
		
		Select select= new Select(selectfilter);
		Common.pause(1);
		select.selectByIndex(4);
		
		Common.waitForElement(driver, searchbox);
		Common.clickableElement(searchbox, driver);
		Common.clickOn(driver, searchbox);
		searchbox.sendKeys(Actual_Email);
		searchbox.sendKeys(Keys.ENTER);
		Common.pause(3);
		
		Common.waitForElement(driver, getEmail);
		get_email=getEmail.getText().trim();
		System.out.println("Email ID is: "+get_email);
		Assert.assertTrue(get_email.equalsIgnoreCase(Actual_Email), "Email Id Doesn't Match");
		
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		
	}

}
