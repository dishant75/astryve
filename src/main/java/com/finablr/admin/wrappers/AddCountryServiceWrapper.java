package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddCountryServiceLocators;
import com.finablr.admin.utilities.Common;

public class AddCountryServiceWrapper {
	
	WebDriver driver;
	String Actual_Title="Country Service Management";
	String Country="Bhutan ";
	String CountryPrefix="541";
	String ServicePrefix="43";
	String Service="Remittance";
	String Configuration="R2I";
	String Service_Provider="Finablr";
	String Transaction_Fee_Category="Fixed Value";
	String Transaction_Fee="4500";
	String VAT_Applicable="Total Amount";
	String VAT="450";
	String Agent_Code="670";
	String Payment_gateway="DIRECPAY";
	String Payment_Service="Netbanking";
	String PageTitle,ActualCountry;
	public static Logger log = LogManager.getLogger(AddCountryServiceWrapper.class);
	
	public AddCountryServiceWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=AddCountryServiceLocators.Configuration_LeftSide)
	WebElement configleft;
	
	@FindBy(xpath=AddCountryServiceLocators.CountryservicePage)
	WebElement countryservice;
	
	@FindBy(xpath=AddCountryServiceLocators.Page_Header)
	WebElement getheader;
	
	
	public void verifyPageTitle()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, configleft);
		Common.clickableElement(configleft, driver);
		Common.clickOn(driver, configleft);
		Common.waitForElement(driver, countryservice);
		Common.clickableElement(countryservice, driver);
		Common.clickOn(driver, countryservice);
		Common.waitForElement(driver, getheader);
		PageTitle=getheader.getText().trim();
		System.out.println("Page title is: "+PageTitle);
		Assert.assertTrue(PageTitle.equalsIgnoreCase(Actual_Title), "Title Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	@FindBy(xpath=AddCountryServiceLocators.Add_btn)
	WebElement Addbtn;
	
	@FindBy(xpath=AddCountryServiceLocators.Input_Country)
	WebElement enterCountry;
	
	@FindBy(xpath=AddCountryServiceLocators.select_Country)
	WebElement selectCountry;
	
	@FindBy(xpath=AddCountryServiceLocators.input_Countryprefix)
	WebElement entercountryPrefix;
	
	@FindBy(xpath=AddCountryServiceLocators.input_Service)
	WebElement enterService;
	
	@FindBy(xpath=AddCountryServiceLocators.select_Service)
	WebElement selectService;
	
	@FindBy(xpath=AddCountryServiceLocators.input_Serviceprefix)
	WebElement enterServicePrefix;
	
	@FindBy(xpath=AddCountryServiceLocators.input_Configuration)
	WebElement enterConfiguration;
	
	@FindBy(xpath=AddCountryServiceLocators.select_Config)
	WebElement selectConfiguration;
	
	@FindBy(xpath=AddCountryServiceLocators.input_ServiceProvider)
	WebElement inputServiceProvider;
	
	@FindBy(xpath=AddCountryServiceLocators.select_Serviceprovider)
	WebElement selectServiceProvider;
	
	@FindBy(xpath=AddCountryServiceLocators.input_TransactionFeeCategory)
	WebElement inputfeeCategory;
	
	@FindBy(xpath=AddCountryServiceLocators.select_TransactionFeeCategory)
	WebElement selectFeeCategory;
	
	@FindBy(xpath=AddCountryServiceLocators.input_Transaction)
	WebElement inputFee;
	
	@FindBy(xpath=AddCountryServiceLocators.input_VATApplicable)
	WebElement inputVatApplicableOn;
	
	@FindBy(xpath=AddCountryServiceLocators.Select_VATApplicable)
	WebElement selectVatApplicableOn;
	
	@FindBy(xpath=AddCountryServiceLocators.input_VAT)
	WebElement inputVAT;
	
	@FindBy(xpath=AddCountryServiceLocators.input_agentCode)
	WebElement inputcode;
	
	@FindBy(xpath=AddCountryServiceLocators.AddPayment_Textlink)
	WebElement txtlink;
	
	@FindBy(xpath=AddCountryServiceLocators.input_PaymentGateway)
	WebElement inputPaymentGateway;
	
	@FindBy(xpath=AddCountryServiceLocators.Select_PaymentGateway)
	WebElement selectPaymentGateway;
	
	@FindBy(xpath=AddCountryServiceLocators.input_PaymentService)
	WebElement inputPaymentService;
	
	@FindBy(xpath=AddCountryServiceLocators.select_PaymentService)
	WebElement selectPaymentService;
	
	@FindBy(xpath=AddCountryServiceLocators.Save_btn)
	WebElement savebtn;
	
	
	
	public void addCountryService()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		
		Common.waitForElement(driver, Addbtn);
		Common.clickableElement(Addbtn, driver);
		Common.clickOn(driver, Addbtn);
		
		
		Common.waitForElement(driver, enterCountry);
		Common.clickableElement(enterCountry, driver);
		Common.clickOn(driver, enterCountry);
		enterCountry.sendKeys(Country);
		
		
		Common.waitForElement(driver, selectCountry);
		Common.clickableElement(selectCountry, driver);
		Common.clickOn(driver, selectCountry);
		
		
		Common.waitForElement(driver, entercountryPrefix);
		Common.clickableElement(entercountryPrefix, driver);
		Common.clickOn(driver, entercountryPrefix);
		entercountryPrefix.sendKeys(CountryPrefix);
		
		
		Common.waitForElement(driver, enterService);
		Common.clickableElement(enterService, driver);
		Common.clickOn(driver, enterService);
		enterService.sendKeys(Service);
		
		
		Common.waitForElement(driver, selectService);
		Common.clickableElement(selectService, driver);
		Common.clickOn(driver, selectService);
		
		
		Common.waitForElement(driver, enterServicePrefix);
		Common.clickableElement(enterServicePrefix, driver);
		Common.clickOn(driver, enterServicePrefix);
		enterServicePrefix.sendKeys(ServicePrefix);
		
		
		Common.waitForElement(driver, enterConfiguration);
		//Common.scrollUpToElement(driver, enterConfiguration);
		Common.pause(1);
		Common.clickableElement(enterConfiguration, driver);
		Common.clickOn(driver, enterConfiguration);
		enterConfiguration.sendKeys(Configuration);
		
		
		Common.waitForElement(driver, selectConfiguration);
		Common.clickableElement(selectConfiguration, driver);
		Common.clickOn(driver, selectConfiguration);
		
		
		Common.waitForElement(driver, inputServiceProvider);
		//Common.scrollUpToElement(driver, inputServiceProvider);
		Common.pause(1);
		Common.clickableElement(inputServiceProvider, driver);
		Common.clickOn(driver, inputServiceProvider);
		inputServiceProvider.sendKeys(Service_Provider);
		
		Common.waitForElement(driver, selectServiceProvider);
		Common.clickableElement(selectServiceProvider, driver);
		Common.clickOn(driver, selectServiceProvider);
		
		Common.waitForElement(driver, inputfeeCategory);
		//Common.scrollUpToElement(driver, inputfeeCategory);
		Common.pause(1);
		Common.clickableElement(inputfeeCategory, driver);
		Common.clickOn(driver, inputfeeCategory);
		inputfeeCategory.sendKeys(Transaction_Fee_Category);
		
		Common.waitForElement(driver, selectFeeCategory);
		Common.clickableElement(selectFeeCategory, driver);
		Common.clickOn(driver, selectFeeCategory);
		
		Common.waitForElement(driver, inputFee);
		Common.clickableElement(inputFee, driver);
		Common.clickOn(driver, inputFee);
		inputFee.sendKeys(Transaction_Fee);
		
		Common.waitForElement(driver, inputVatApplicableOn);
		//Common.scrollUpToElement(driver, inputVatApplicableOn);
		Common.pause(1);
		Common.clickableElement(inputVatApplicableOn, driver);
		Common.clickOn(driver, inputVatApplicableOn);
		inputVatApplicableOn.sendKeys(VAT_Applicable);
		
		Common.waitForElement(driver, selectVatApplicableOn);
		Common.clickableElement(selectVatApplicableOn, driver);
		Common.clickOn(driver, selectVatApplicableOn);
		
		Common.waitForElement(driver, inputVAT);
		Common.clickableElement(inputVAT, driver);
		Common.clickOn(driver, inputVAT);
		inputVAT.sendKeys(VAT);
		
		Common.waitForElement(driver, inputcode);
		//Common.scrollUpToElement(driver, inputcode);
		Common.pause(1);
		Common.clickableElement(inputcode, driver);
		Common.clickOn(driver, inputcode);
		inputcode.sendKeys(Agent_Code);
		
		Common.waitForElement(driver, txtlink);
		Common.clickableElement(txtlink, driver);
		Common.clickOn(driver, txtlink);
		
		Common.waitForElement(driver, inputPaymentGateway);
		//Common.scrollUpToElement(driver, inputPaymentGateway);
		Common.pause(1);
		Common.clickableElement(inputPaymentGateway, driver);
		Common.clickOn(driver, inputPaymentGateway);
		inputPaymentGateway.sendKeys(Payment_gateway);
		
		Common.waitForElement(driver, selectPaymentGateway);
		Common.clickableElement(selectPaymentGateway, driver);
		Common.clickOn(driver, selectPaymentGateway);
		
		Common.waitForElement(driver, inputPaymentService);
		//Common.scrollUpToElement(driver, inputPaymentService);
		Common.pause(1);
		Common.clickableElement(inputPaymentService, driver);
		Common.clickOn(driver, inputPaymentService);
		inputPaymentService.sendKeys(Payment_Service);
		
		Common.waitForElement(driver, selectPaymentService);
		Common.clickableElement(selectPaymentService, driver);
		Common.clickOn(driver, selectPaymentService);
		
		Common.waitForElement(driver, savebtn);
		//Common.scrollToVertical(driver, savebtn);
		Common.pause(1);
		Common.clickableElement(savebtn, driver);
		Common.clickOn(driver, savebtn);
		Common.pause(2);
		
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=AddCountryServiceLocators.verifyCountry)
	WebElement verifyCountry;
	
	@FindBy(xpath=AddCountryServiceLocators.Back_btn)
	WebElement backbtn;
	
	
	public void verifyCountry()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, verifyCountry);
		Common.pause(2);
		ActualCountry=verifyCountry.getText().trim();
		Assert.assertTrue(ActualCountry.equalsIgnoreCase(Country),"Country Service Doesn't Added");
		Common.pause(1);
		/*Common.waitForElement(driver, backbtn);
		Common.scrollUpToElement(driver, backbtn);
		Common.pause(3);
		Common.clickableElement(backbtn, driver);
		Common.clickOn(driver, backbtn);
		Common.pause(2);*/
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
