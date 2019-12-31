package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.TransactionListingLocators;
//import com.demo.init.AbstractPage;
//import com.finablr.admin.locators.TransactionListingLocators;
import com.finablr.admin.utilities.Common;

public class TransactionListingWrapper  {

	WebDriver driver;
	public static Logger log = LogManager.getLogger(TransactionListingWrapper.class);

	public TransactionListingWrapper(WebDriver remotedriver) {
		// TODO Auto-generated constructor stub
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver= remotedriver;
		PageFactory.initElements(remotedriver, this);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	@FindBy(xpath=TransactionListingLocators.MENU_TRANSACTION_LISTING_XPATH)
	WebElement title;

	public void getTitleOfTrlisting() {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		String origin = "Transaction Listing";
		Common.waitForElement(driver, title);
		String s1 = title.getText();
		Common.pause(1);
		Assert.assertTrue(s1.equalsIgnoreCase(origin),"Title Doesn't match");
		Common.pause(1);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());

	}
	/*@FindBy(xpath=TransactionListingLocators.Select_Classname)
	WebElement drpdownTransaction;
	
	public void selectFilter()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(3);
		Select select= new Select(drpdownTransaction);
		Common.pause(2);
		select.selectByIndex(1);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}*/
	
	@FindBy(xpath=TransactionListingLocators.TXTBOX_SEARCHBAR_XPATH)
	WebElement searchareatxt;
	public void searchArea()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.clickOn(driver, searchareatxt);
		Common.type(searchareatxt, "RI000000351");
		searchareatxt.sendKeys(Keys.ENTER);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	@FindBy(xpath=TransactionListingLocators.GET_ID_FROMTHESEARCH_XPATH)
	WebElement getid;
	
	public void verifyTID()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		String OriginID="RI000000351";
		String id= getid.getText();
		Common.pause(2);
		Assert.assertTrue(id.equalsIgnoreCase(OriginID),"Id Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}


}
