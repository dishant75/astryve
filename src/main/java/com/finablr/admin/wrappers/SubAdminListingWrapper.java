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
import com.finablr.admin.locators.SubAdminListingLocators;
import com.finablr.admin.utilities.Common;

public class SubAdminListingWrapper {
	
	WebDriver driver;
	String Actual_title="User Management";
	String Actual_emailId="dishant.saraiya@peaas.co";
	String getTitle,getEmailID;
	public static Logger log = LogManager.getLogger(SubAdminListingWrapper.class);
	
	public SubAdminListingWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=SubAdminListingLocators.UserManagement_LeftSide)
	WebElement usermanagementLeft;
	
	@FindBy(xpath=SubAdminListingLocators.Select_Filter)
	WebElement selectdrpdown;
	
	@FindBy(xpath=SubAdminListingLocators.Search)
	WebElement Searchbox;
	
	@FindBy(xpath=SubAdminListingLocators.Get_EmailAddress)
	WebElement getemailid;
	
	@FindBy(xpath=SubAdminListingLocators.Get_Pagetitle)
	WebElement getPagetitle;
	
	public void searchUser()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, usermanagementLeft);
		Common.clickableElement(usermanagementLeft, driver);
		Common.clickOn(driver, usermanagementLeft);
		
		Common.waitForElement(driver, getPagetitle);
		getTitle=getPagetitle.getText().trim();
		System.out.println("Page title is: "+getTitle);
		Assert.assertTrue(getTitle.equalsIgnoreCase(Actual_title), "Page Title Doesn't Match");
		
		Select select= new Select(selectdrpdown);
		Common.pause(1);
		select.selectByIndex(4);
		
		Common.waitForElement(driver, Searchbox);
		Common.clickableElement(Searchbox, driver);
		Common.clickOn(driver, Searchbox);
		Searchbox.sendKeys(Actual_emailId);
		Searchbox.sendKeys(Keys.ENTER);
		Common.pause(3);
		
		Common.waitForElement(driver, usermanagementLeft);
		getEmailID=getemailid.getText().trim();
		System.out.println("Email ID is: "+getEmailID);
		Assert.assertTrue(getEmailID.equalsIgnoreCase(Actual_emailId), "Email Id Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
