package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddServiceProviderLocators;
import com.finablr.admin.utilities.Common;

public class AddServiceProviderWrapper {
	
	WebDriver driver;
	String Actual_title="Add Service Provider Configuration";
	String getTitle;
	String Service_ProviderCode="Fox847";
	String Service_providerName="Foxstar";
	String Bank_Name="Duecthe bank";
	String Bank_Branch="Hampshire";
	String Bank_ACNO="5647893462834";
	String Trade_No="6475984554";
	String Tax_No="24545628956";
	
	public static Logger log = LogManager.getLogger(AddServiceProviderWrapper.class);
	
	public AddServiceProviderWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	
	@FindBy(xpath=AddServiceProviderLocators.Configuration_LeftSide)
	WebElement configleft;
	
	
	@FindBy(xpath=AddServiceProviderLocators.ServiceProviderPage)
	WebElement Servicepage;
	
	@FindBy(xpath=AddServiceProviderLocators.Add_btn)
	WebElement addbtn;
	
	@FindBy(xpath=AddServiceProviderLocators.Page_Header)
	WebElement pageheader;
	
	public void verifyTitle()
	{
		
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Common.waitForElement(driver, configleft);
		Common.clickableElement(configleft, driver);
		Common.clickOn(driver, configleft);
		
		Common.waitForElement(driver, Servicepage);
		Common.clickableElement(Servicepage, driver);
		Common.clickOn(driver, Servicepage);
		
		Common.waitForElement(driver, addbtn);
		Common.clickableElement(addbtn, driver);
		Common.clickOn(driver, addbtn);
		
		Common.waitForElement(driver, pageheader);
		getTitle=pageheader.getText().trim();
		System.out.println("Page title is: "+getTitle);
		
		Assert.assertTrue(getTitle.equalsIgnoreCase(Actual_title),"Title Doesn't Match");
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	
	@FindBy(xpath=AddServiceProviderLocators.input_serviceProviderCode)
	WebElement serviceprovider;
	
	@FindBy(xpath=AddServiceProviderLocators.input_ServiceProvidername)
	WebElement serviceproviderName;
	
	@FindBy(xpath=AddServiceProviderLocators.input_BankName)
	WebElement bankname;
	
	@FindBy(xpath=AddServiceProviderLocators.input_BankBranch)
	WebElement bankBranch;
	
	@FindBy(xpath=AddServiceProviderLocators.input_BankAc)
	WebElement bankacno;
	
	@FindBy(xpath=AddServiceProviderLocators.input_LicenseNo)
	WebElement licenseno;
	
	@FindBy(xpath=AddServiceProviderLocators.input_TaxNo)
	WebElement taxno;
	
	@FindBy(xpath=AddServiceProviderLocators.Save_btn)
	WebElement savebtn;
	
	public void addProvider()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Common.waitForElement(driver, serviceprovider);
		Common.clickableElement(serviceprovider, driver);
		Common.clickOn(driver, serviceprovider);
		serviceprovider.sendKeys(Service_ProviderCode);
		
		Common.waitForElement(driver, serviceproviderName);
		Common.clickableElement(serviceproviderName, driver);
		Common.clickOn(driver, serviceproviderName);
		serviceproviderName.sendKeys(Service_providerName);
		
		Common.waitForElement(driver, bankname);
		Common.clickableElement(bankname, driver);
		Common.clickOn(driver, bankname);
		bankname.sendKeys(Bank_Name);
		
		Common.waitForElement(driver, bankBranch);
		Common.clickableElement(bankBranch, driver);
		Common.clickOn(driver, bankBranch);
		bankBranch.sendKeys(Bank_Branch);
		
		Common.waitForElement(driver, bankacno);
		Common.clickableElement(bankacno, driver);
		Common.clickOn(driver, bankacno);
		bankacno.sendKeys(Bank_ACNO);
		
		Common.waitForElement(driver, licenseno);
		Common.clickableElement(licenseno, driver);
		Common.clickOn(driver, licenseno);
		licenseno.sendKeys(Trade_No);
		
		Common.waitForElement(driver, taxno);
		Common.clickableElement(taxno, driver);
		Common.clickOn(driver, taxno);
		taxno.sendKeys(Tax_No);
		
		Common.waitForElement(driver, savebtn);
		Common.clickableElement(savebtn, driver);
		Common.clickOn(driver, savebtn);
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
