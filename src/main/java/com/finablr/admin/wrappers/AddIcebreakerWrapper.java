package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddIceBreakerLocators;
import com.finablr.admin.utilities.Common;

public class AddIcebreakerWrapper {
	
	WebDriver driver;
	String ActualPageTitle="Icebreaker";
	String Actualheader="Icebreaker Name";
	String Icebreaker_name="Proud to be an Indian";
	String pageTitle,Addpopup_header;
	public static Logger log = LogManager.getLogger(AddIcebreakerWrapper.class);
	
	public AddIcebreakerWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	
	@FindBy(xpath=AddIceBreakerLocators.Icebreaker_LeftSide)
	WebElement icebreakerleft;
	
	@FindBy(xpath=AddIceBreakerLocators.PageTitle)
	WebElement pagetitle;
	
	@FindBy(xpath=AddIceBreakerLocators.Add_Icebreaker)
	WebElement addicebreakericon;
	
	@FindBy(xpath=AddIceBreakerLocators.Scroll)
	WebElement scrollleftside;
	
	public void verifyPageTitle()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, icebreakerleft);
		Common.scrollToVertical(driver, icebreakerleft);
		Common.clickableElement(icebreakerleft, driver);
		Common.clickOn(driver, icebreakerleft);
		Common.waitForElement(driver, pagetitle);
		pageTitle=pagetitle.getText().trim();
		Common.pause(1);
		System.out.println("Page title is: "+pageTitle);
		Assert.assertTrue(pageTitle.equalsIgnoreCase(ActualPageTitle),"Title Doesn't Match");
		Common.waitForElement(driver, addicebreakericon);
		Common.clickOn(driver, addicebreakericon);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=AddIceBreakerLocators.Header_AddIcebreaker)
	WebElement header_addib;
	
	@FindBy(xpath=AddIceBreakerLocators.Enter_IceBreaker_Title)
	WebElement  entericebreaker;
	
	@FindBy(xpath=AddIceBreakerLocators.Enable_Toggle)
	WebElement toggleactive;
	
	@FindBy(xpath=AddIceBreakerLocators.Add_button)
	WebElement addbtn;
	
	public void addIcebreaker()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, header_addib);
		Addpopup_header=header_addib.getText().trim();
		Common.pause(1);
		System.out.println("Header of the Popup is: "+Addpopup_header);
		Common.waitForElement(driver, entericebreaker);
		Common.clickOn(driver, entericebreaker);
		entericebreaker.sendKeys(Icebreaker_name);
		Common.pause(1);
		Assert.assertTrue(Addpopup_header.equalsIgnoreCase(Actualheader), "Header Dosn't Match");
		toggleactive.isDisplayed();
		Common.waitForElement(driver, addbtn);
		Common.clickableElement(addbtn, driver);
		Common.clickOn(driver, addbtn);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
