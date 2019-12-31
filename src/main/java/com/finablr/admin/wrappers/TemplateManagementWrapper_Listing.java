package com.finablr.admin.wrappers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.TemplateManagementListing_Loactors;
import com.finablr.admin.utilities.Common;

public class TemplateManagementWrapper_Listing {
	
	 WebDriver driver;
	String code,contenttype,viewcode,viewcontenttype;
	public static Logger log = LogManager.getLogger(TemplateManagementWrapper_Listing.class);
	
	public TemplateManagementWrapper_Listing(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=TemplateManagementListing_Loactors.Templatemngmnt_xpath)
	WebElement templatemanagement;
	
	
	public void clkTemplateManagement()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(3);
		Common.waitForElement(driver, templatemanagement);
		Common.clickableElement(templatemanagement, driver);
	     Common.clickOn(driver, templatemanagement);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=TemplateManagementListing_Loactors.Getcode_xpath)
	WebElement getcode;
	@FindBy(xpath=TemplateManagementListing_Loactors.GetContentType_xpath)
	WebElement getcontentType;
	@FindBy(xpath=TemplateManagementListing_Loactors.Viewicon_xpath)
	WebElement viewicon;
	
	public void getTextListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, getcode);
		code= getcode.getText();
		Common.pause(2);
		System.out.println(code);
		Common.pause(2);
		Common.waitForElement(driver, getcontentType);
		Common.scrollToHorizontal(driver, getcontentType);
		Common.pause(2);
		contenttype= getcontentType.getText();
		Common.pause(2);
		System.out.println(contenttype);
		Common.waitForElement(driver, viewicon);
		Common.scrollToHorizontal(driver, viewicon);
		Common.clickableElement(viewicon, driver);
		Common.clickOn(driver, viewicon);
		Common.pause(5);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=TemplateManagementListing_Loactors.Getcode_viewscreen_xpath)
	WebElement getcodeview;
	@FindBy(xpath=TemplateManagementListing_Loactors.GetContenttype_viewscreen_xpath)
	WebElement getcontenttypeView;
	
	
	public void getTextViewScreen() 
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, getcodeview);
		viewcode=getcodeview.getText();
		Common.pause(2);
		System.out.println(viewcode);
		Common.waitForElement(driver, getcontenttypeView);
		//Common.scrollToVertical(driver, getcontenttypeView);
		Common.pause(2);
		viewcontenttype=getcontenttypeView.getText();
		Common.pause(2);
		System.out.println(viewcontenttype);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	public void verifyFields()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Boolean b1=code.equalsIgnoreCase(viewcode);
		Common.pause(2);
		Assert.assertTrue(b1, "Code mis-match");
		Common.pause(2);
		Boolean b2=contenttype.equalsIgnoreCase(viewcontenttype);
		Common.pause(2);
		Assert.assertTrue(b2, "Content-type mis-match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
