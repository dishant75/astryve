package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.ViewTransactionLocators;
import com.finablr.admin.utilities.Common;

public class ViewTransactionWrapper {
	WebDriver driver;
	String trnsID, getamount, trnsstatus, viewreferenceno,viewsentamnt,viewstatus,mainrefrence;
	public static Logger log = LogManager.getLogger(ViewTransactionWrapper.class);
	
	public ViewTransactionWrapper(WebDriver remotedriver)
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver= remotedriver;
		PageFactory.initElements(remotedriver, this);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}
	
	@FindBy(xpath=ViewTransactionLocators.Select_Classname)
	WebElement drpdownTransaction;
	
	public void selectFilter()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(3);
		Select select= new Select(drpdownTransaction);
		Common.pause(2);
		select.selectByIndex(1);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	@FindBy(xpath=ViewTransactionLocators.Select_Service)
	WebElement selservice;
	
	public void selectService()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(3);
		Select selectser=new Select(selservice);
		Common.pause(1);
		Common.waitForElement(driver, selservice);
		selectser.selectByIndex(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	@FindBy(xpath=ViewTransactionLocators.Get_TID)
	WebElement transactionId;
	
	@FindBy(xpath=ViewTransactionLocators.Get_Amount)
	WebElement amount;
	
	@FindBy(xpath=ViewTransactionLocators.Get_Status)
	WebElement status;
	
	public void getInfo()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, transactionId);
		trnsID=transactionId.getText();
		Common.pause(1);
		System.out.println("Transaction Id is: "+trnsID);
		Common.waitForElement(driver, amount);
		getamount=amount.getText();
		Common.pause(1);
		System.out.println("Transaction Amount is: "+getamount);
		Common.waitForElement(driver, status);
		trnsstatus=status.getText();
		Common.pause(1);
		System.out.println("Transaction Status is: "+trnsstatus);
		Common.pause(1);
		Common.clickableElement(transactionId, driver);
		Common.clickOn(driver, transactionId);
		Common.pause(3);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=ViewTransactionLocators.Get_TransactionID)
	WebElement tid;
	
	@FindBy(xpath=ViewTransactionLocators.Get_SendMoney)
	WebElement getsendMoney;
	
	@FindBy(xpath=ViewTransactionLocators.Get_ViewStatus)
	WebElement vwstatus;
	
	
	public void getviewElements()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, tid);
		viewreferenceno=tid.getText();
		Common.pause(1);
		mainrefrence=viewreferenceno.replace("Transaction Id :","").trim();
		Common.pause(1);
		System.out.println("Transaction ID is : "+mainrefrence);
		Common.waitForElement(driver, getsendMoney);
		viewsentamnt=getsendMoney.getText();
		Common.pause(1);
		System.out.println("Sent Amount is: "+viewsentamnt);
		Common.waitForElement(driver, vwstatus);
		viewstatus=vwstatus.getText();
		Common.pause(1);
		System.out.println("Transaction Status is: "+viewstatus);
		Common.pause(1);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	public void verifyelements()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Assert.assertTrue(mainrefrence.equalsIgnoreCase(trnsID),"Id doesn't match");
		Common.pause(1);
		Assert.assertTrue(viewsentamnt.equalsIgnoreCase(getamount), "Amount Doesn't Match");
		Common.pause(1);
		Assert.assertTrue(viewstatus.equalsIgnoreCase(trnsstatus), "Status Doesn't match");
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
