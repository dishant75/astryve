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
import com.finablr.admin.locators.TemplateListingLocators;
import com.finablr.admin.utilities.Common;

public class TemplateListingWrapper {
	
	WebDriver driver;
	String Pagetitle,Templatecode;
	String ActualTemplatecode="PUSH_MT_SUCCESS";
	public static Logger log = LogManager.getLogger(TemplateListingWrapper.class);
	
	public TemplateListingWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=TemplateListingLocators.Page_title)
	WebElement pageheader;
	
	@FindBy(xpath=TemplateListingLocators.Template_LeftSide)
	WebElement templateleft;
	
	public void verifyPageTitle()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.clickableElement(templateleft, driver);
		Common.clickOn(driver, templateleft);
		Common.waitForElement(driver, pageheader);
		Common.pause(2);
		Pagetitle=pageheader.getText();
		Common.pause(1);
		System.out.println("Page title is : "+Pagetitle);
		Assert.assertTrue(Pagetitle.equalsIgnoreCase("Template Management"), "Header doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=TemplateListingLocators.Select_Classname)
	WebElement slectdropdown;
	
	@FindBy(xpath=TemplateListingLocators.TXTBOX_SEARCHBAR_XPATH)
	WebElement serachbox;
	
	public void templateListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Select select= new Select(slectdropdown);
		Common.pause(1);
		select.selectByIndex(1);
		Common.clickableElement(serachbox, driver);
		Common.pause(1);
		Common.clickOn(driver, serachbox);
		serachbox.sendKeys(ActualTemplatecode);
		serachbox.sendKeys(Keys.ENTER);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}
	
	
	@FindBy(xpath=TemplateListingLocators.Get_TemplateCode)
	WebElement gettcode;
	
	public void verifyList()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, gettcode);
		Templatecode=gettcode.getText();
		Common.pause(1);
		System.out.println("Template code is: "+Templatecode);
		Assert.assertTrue(Templatecode.equalsIgnoreCase(ActualTemplatecode),"Template Code Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
