package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.ViewTemplateLocators;
import com.finablr.admin.utilities.Common;

public class ViewTemplateWrapper {
	
	WebDriver driver;
	String listingcode,listingtiitle,listingfromdate,listingtilldate,listingchannel,viewcode,viewtitle,viewchannel,viewfromdate,viewtilldate;
	public static Logger log = LogManager.getLogger(ViewTemplateWrapper.class);
	public ViewTemplateWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=ViewTemplateLocators.Get_Channel)
	WebElement getchannel;
	
	@FindBy(xpath=ViewTemplateLocators.Get_TemplateCode)
	WebElement getcode;
	
	@FindBy(xpath=ViewTemplateLocators.Get_Title)
	WebElement gettitle;
	
	@FindBy(xpath=ViewTemplateLocators.Get_EffectivefromDate)
	WebElement getefffromdate;
	
	@FindBy(xpath=ViewTemplateLocators.Get_EffectiveTillDate)
	WebElement gettilldate;
	
	public void getListingDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Common.waitForElement(driver,getcode);
		listingcode=getcode.getText();
		Common.pause(1);
		System.out.println("Listing Code is: "+listingcode);
		listingtiitle=gettitle.getText();
		Common.pause(1);
		System.out.println("Listing Title is: "+listingtiitle);
		listingchannel=getchannel.getText();
		Common.pause(1);
		System.out.println("Listing Channel is: "+listingchannel);
		listingfromdate=getefffromdate.getText().trim();
		Common.pause(1);
		System.out.println("Listing Effective From date is: "+listingfromdate);
		listingtilldate=gettilldate.getText().trim();
		Common.pause(1);
		System.out.println("Listing Effective Till date is: "+listingtilldate);
		Common.clickOn(driver, getcode);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=ViewTemplateLocators.Get_ViewCode)
	WebElement getviewcode;
	
	@FindBy(xpath=ViewTemplateLocators.Get_ViewChannel)
	WebElement getviewchannel;
	
	@FindBy(xpath=ViewTemplateLocators.Get_Viewtitle)
	WebElement getviewtitle;
	
	@FindBy(xpath=ViewTemplateLocators.Get_ViewEffectiveFrom)
	WebElement getviewfrom;
	
	@FindBy(xpath=ViewTemplateLocators.Get_ViewEffectiveTill)
	WebElement getviewtill;
	
	public void getViewDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Common.waitForElement(driver,getviewcode);
		viewcode=getviewcode.getText();
		Common.pause(1);
		System.out.println("View Code is: "+viewcode);
		viewtitle=getviewtitle.getText();
		Common.pause(1);
		System.out.println("View Title is: "+viewtitle);
		viewchannel=getviewchannel.getText();
		Common.pause(1);
		System.out.println("View Channel is: "+viewchannel);
		viewfromdate=getviewfrom.getText().replace("20:0", "").replace("ober", "").trim();
		Common.pause(1);
		System.out.println("View effective from date is: "+viewfromdate);
		viewtilldate=getviewtill.getText().trim();
		Common.pause(1);
		System.out.println("View effective till date is: "+viewtilldate);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	public void verifyViewTemplateData()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Assert.assertTrue(viewcode.equalsIgnoreCase(listingcode), "Code doesn't match");
		Common.pause(1);
		Assert.assertTrue(viewchannel.equalsIgnoreCase(listingchannel), "Channel doesn't match");
		Common.pause(1);
		Assert.assertTrue(viewtitle.equalsIgnoreCase(listingtiitle), "Title doesn't match");
		Common.pause(1);
		/*Assert.assertTrue(viewfromdate.equalsIgnoreCase(listingfromdate), "Effective From date doesn't match");
		Common.pause(1);
		Assert.assertTrue(viewtilldate.equalsIgnoreCase(listingtilldate), "Effective Till doesn't match");
		Common.pause(1);*/
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
