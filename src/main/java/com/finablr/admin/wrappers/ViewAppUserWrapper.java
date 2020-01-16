package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.ViewAppUserLocators;
import com.finablr.admin.utilities.Common;

public class ViewAppUserWrapper {
	
	WebDriver driver;
	String fullname,mobile,email,status,view_fullname,view_mobile,view_email,view_status,Header;
	String Actual_Header="View App User";
	
	public static Logger log = LogManager.getLogger(ViewAppUserWrapper.class);
	
	public ViewAppUserWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=ViewAppUserLocators.Get_FullName)
	WebElement getFullname;
	
	@FindBy(xpath=ViewAppUserLocators.Get_EmailAddress)
	WebElement getEmail;
	
	@FindBy(xpath=ViewAppUserLocators.Get_Mobile_Number)
	WebElement getMobile;
	
	@FindBy(xpath=ViewAppUserLocators.Get_KYC_Status)
	WebElement getKYC;
	
	
	
	public void getSearchDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		
		Common.waitForElement(driver, getFullname);
		fullname=getFullname.getText().trim();
		System.out.println("Full name: "+fullname);
		
		Common.waitForElement(driver, getEmail);
		email=getEmail.getText().trim();
		System.out.println("Email: "+email);
		
		Common.waitForElement(driver, getMobile);
		mobile=getMobile.getText().trim();
		System.out.println("Mobile: "+mobile);
		

		Common.waitForElement(driver, getKYC);
		status=getKYC.getText().trim();
		System.out.println("Status: "+status);
		
		Common.clickableElement(getFullname, driver);
		Common.clickOn(driver, getFullname);
		Common.pause(3);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}
	
	@FindBy(xpath=ViewAppUserLocators.Get_View_Email)
	WebElement viewemail;
	
	@FindBy(xpath=ViewAppUserLocators.Get_View_Fullname)
	WebElement viewname;
	
	@FindBy(xpath=ViewAppUserLocators.Get_View_KYC_Status)
	WebElement viewstatus;
	
	@FindBy(xpath=ViewAppUserLocators.Get_View_MobileNumber)
	WebElement viewMobile;
	
	@FindBy(xpath=ViewAppUserLocators.Get_Header)
	WebElement header;
	
	
	public void  getViewDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());

		
		Common.waitForElement(driver, header);
		Header=header.getText().trim();
		System.out.println("Header of the Page: "+Header);
		
		Common.waitForElement(driver, viewemail);
		view_email=viewemail.getAttribute("value").trim();
		System.out.println("View Email: "+view_email);
		
		Common.waitForElement(driver, viewname);
		view_fullname=viewname.getAttribute("value").trim();
		System.out.println("View Full name: "+view_fullname);
		
		Common.waitForElement(driver, viewMobile);
		view_mobile=viewMobile.getAttribute("value").trim();
		System.out.println("View MobileNumber: "+view_mobile);
		
		Common.waitForElement(driver, viewstatus);
		view_status=viewstatus.getAttribute("value").trim();
		System.out.println("View KYC status: "+view_status);
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	public void compareValues()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Assert.assertTrue(Header.equalsIgnoreCase(Actual_Header), "Header Doesn't Match");
		
		Assert.assertTrue(email.equalsIgnoreCase(view_email), "Ëmail Doesn't Match");
		
		Assert.assertTrue(fullname.equalsIgnoreCase(view_fullname), "Full name Doesn't match");
		
		Assert.assertTrue(mobile.equalsIgnoreCase(view_mobile), "Mobile Number Doesn't match");
		
		Assert.assertTrue(status.equalsIgnoreCase(view_status), "KYC status  Doesn't match");
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
