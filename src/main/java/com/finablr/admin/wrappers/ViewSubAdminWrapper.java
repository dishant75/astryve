package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.ViewSubAdminLocators;
import com.finablr.admin.utilities.Common;

public class ViewSubAdminWrapper {
	
	WebDriver driver;
	String FullnameActual,getEmail,getRole,viewFirstname,viewLastName,viewActualEmail,viewActualRole,ActualFirstname,ActualLastname;
	public static Logger log = LogManager.getLogger(SubAdminListingWrapper.class);
	
	public ViewSubAdminWrapper(WebDriver remotedriver) {
		
		driver=remotedriver;
		
		PageFactory.initElements(remotedriver, this);
		
	}
	
	
	@FindBy(xpath=ViewSubAdminLocators.Get_Fullname)
	WebElement fullname;
	
	@FindBy(xpath=ViewSubAdminLocators.Get_EmailAddress)
	WebElement emailAdd;
	
	@FindBy(xpath=ViewSubAdminLocators.Get_Role)
	WebElement getrole;
	
	public void getSearchDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, fullname);
		FullnameActual=fullname.getText().trim();
		System.out.println("Actual Full Name is: "+FullnameActual);
		ActualFirstname=FullnameActual.replace("Saraiya","").trim();
		System.out.println("Actual Firstname: "+ActualFirstname);
		ActualLastname=FullnameActual.replace("Dishant","").trim();
		System.out.println("Actual Lastname: "+ActualLastname);
		Common.waitForElement(driver, emailAdd);
		getEmail=emailAdd.getText().trim();
		System.out.println("Email Id is:"+getEmail);
		Common.waitForElement(driver, getrole);
		getRole=getrole.getText().trim();
		System.out.println("Role of the Subadmin is: "+getRole);
		Common.clickableElement(fullname, driver);
		Common.clickOn(driver, fullname);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=ViewSubAdminLocators.View_FirstName)
	WebElement viewfirstname;
	
	@FindBy(xpath=ViewSubAdminLocators.View_Lastname)
	WebElement viewlastname;
	
	@FindBy(xpath=ViewSubAdminLocators.View_Role)
	WebElement viewRole;
	
	@FindBy(xpath=ViewSubAdminLocators.View_Email)
	WebElement viewEmail;
	
	public void viewdetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		
		Common.waitForElement(driver, viewfirstname);
		viewFirstname=viewfirstname.getAttribute("value").trim();
		System.out.println("View First Name: "+viewFirstname);
		
		Common.waitForElement(driver, viewlastname);
		viewLastName=viewlastname.getAttribute("value").trim();
		System.out.println("View Last Name: "+viewLastName);
		
		Common.waitForElement(driver, viewEmail);
		viewActualEmail=viewEmail.getAttribute("value").trim();
		System.out.println("View Email Id: "+viewActualEmail);
		
		Common.waitForElement(driver, viewRole);
		viewActualRole=viewRole.getAttribute("value").trim();
		System.out.println("View Role: "+viewActualRole);
		
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}
	
	public void veirfyResult()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(viewFirstname.equalsIgnoreCase(ActualFirstname), "Firstname is not matched");
		Assert.assertTrue(viewLastName.equalsIgnoreCase(ActualLastname), "Lastname is not matched");
		Assert.assertTrue(viewActualEmail.equalsIgnoreCase(getEmail), "Email id doesn't match");
		Assert.assertTrue(viewActualRole.equalsIgnoreCase(getRole), "Role Doesn't match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}

}
