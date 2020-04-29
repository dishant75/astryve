package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.Constants;
import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddHelpServicesLocators;
import com.finablr.admin.utilities.Common;

public class AddHelpServicesWrapper {
	
	WebDriver driver;
	String PageTitle,AddserviceTitle,randomcharacter;
	String ActualPageTitle="Help Services";
	String Actual_Addservice_Title="Add Service";
	String Service_Name="Test Demo";
	public static Logger log = LogManager.getLogger(AddHelpServicesWrapper.class);
	
	public AddHelpServicesWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=AddHelpServicesLocators.Helpservice_LeftSide)
	WebElement helpleftside;
	
	@FindBy(xpath=AddHelpServicesLocators.PageTitle)
	WebElement pagetitle;
	
	@FindBy(xpath=AddHelpServicesLocators.Add_Services)
	WebElement addservice;
	
	public void helpserviceListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.clickableElement(helpleftside, driver);
		Common.clickOn(driver, helpleftside);
		Common.pause(2);
		Common.waitForElement(driver, pagetitle);
		PageTitle=pagetitle.getText().trim();
		Common.pause(1);
		System.out.println("Page title is: "+PageTitle);
		Assert.assertTrue(PageTitle.equalsIgnoreCase(ActualPageTitle), "Title Doesn't Match");
		Common.clickableElement(addservice, driver);
		Common.clickOn(driver, addservice);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=AddHelpServicesLocators.Enter_Service_Title)
	WebElement enterservice;
	
	@FindBy(xpath=AddHelpServicesLocators.Header_AddService)
	WebElement Addserviceheader;
	
	@FindBy(xpath=AddHelpServicesLocators.img_file)
	WebElement uploadimg;
	
	@FindBy(xpath=AddHelpServicesLocators.Save_buttonn)
	WebElement savebtn;
	
	
	public void addhelpService()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, Addserviceheader);
		Common.pause(1);
		AddserviceTitle=Addserviceheader.getText().trim();
		Common.pause(1);
		System.out.println("Add service Title is: "+AddserviceTitle);
		Assert.assertTrue(AddserviceTitle.equalsIgnoreCase(Actual_Addservice_Title),"Addservices Title Doesn't Match");
		Common.pause(1);
		Common.clickableElement(enterservice, driver);
		Common.clickOn(driver, enterservice);
		Common.pause(1);
		randomcharacter=Common.generateRandomChars(5);
		randomcharacter=randomcharacter.toLowerCase();
		Common.pause(1);
		System.out.println("Service Name is: "+randomcharacter);
		enterservice.sendKeys(Service_Name+" "+randomcharacter);
		Common.pause(1);
		uploadimg.sendKeys(Constants.TestData+"callOff.png");
		Common.pause(2);
		Common.clickableElement(savebtn, driver);
		Common.clickOn(driver, savebtn);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	
		
	}

}
