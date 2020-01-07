package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finablr.admin.constants.Constants;
import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddIllustrationLocators;
import com.finablr.admin.utilities.Common;

public class AddIllustrationWrapper {

	WebDriver driver;
	String Actual_Header="Add Event";
	String EventName="Test Demo";
	String Country="India";
	String getHeader;
	public static Logger log = LogManager.getLogger(ViewTemplateWrapper.class);

	public AddIllustrationWrapper(WebDriver remotedriver) {
		driver = remotedriver;
		PageFactory.initElements(remotedriver, this);

	}
	
	
	@FindBy(xpath=AddIllustrationLocators.Add_event)
	WebElement addeventbtn;
	
	@FindBy(xpath=AddIllustrationLocators.Page_Header)
	WebElement pageheader;
	
	@FindBy(xpath=AddIllustrationLocators.event_Name)
	WebElement eventname;
	
	@FindBy(xpath=AddIllustrationLocators.Country_name)
	WebElement countryname;
	
	@FindBy(xpath=AddIllustrationLocators.Select_Country)
	WebElement selectcountry;
	
	@FindBy(xpath=AddIllustrationLocators.Upload_Img)
	WebElement img;
	
	@FindBy(xpath=AddIllustrationLocators.Save_btn)
	WebElement savebtn;
	
	
	public void addEvent()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, addeventbtn);
		Common.clickableElement(addeventbtn, driver);
		Common.clickOn(driver, addeventbtn);
		Common.waitForElement(driver, pageheader);
		getHeader=pageheader.getText().trim();
		System.out.println("Header of the page is: "+getHeader);
		Common.waitForElement(driver, eventname);
		Common.clickableElement(eventname, driver);
		Common.clickOn(driver, eventname);
		eventname.sendKeys(EventName);
		Common.clickableElement(countryname, driver);
		Common.clickOn(driver, countryname);
		Common.clickOn(driver, countryname);
		countryname.sendKeys(Country);
		Common.waitForElement(driver, selectcountry);
		Common.clickableElement(selectcountry, driver);
		Common.clickOn(driver, selectcountry);
		img.sendKeys(Constants.TestData+"gift_card_thankyou.jpg");
		Common.pause(2);
		Common.clickableElement(savebtn, driver);
		Common.clickOn(driver, savebtn);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
