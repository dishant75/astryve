package com.finablr.admin.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.locators.ViewScreenLocators;
import com.finablr.admin.utilities.Common;

public class ViewScreenWrapper {
	
	WebDriver driver;
	String amuntsent;
	String amuntreceive;
	String status;
	String amuntsentview;
	String amuntreceiveview;
	String statusview;

	public ViewScreenWrapper(WebDriver remotedriver) {
		driver= remotedriver;
		PageFactory.initElements(remotedriver, this);
		
	}
	
	@FindBy(xpath=ViewScreenLocators.VIEW_ICON_XPATH)
	WebElement viewicon;
	
	public void clkviewIcon()
	{
		Common.waitForElement(driver, viewicon);
		Common.scrollToHorizontal(driver, viewicon);
		Common.clickableElement(viewicon, driver);
		Common.clickOn(driver, viewicon);
	}
	
	@FindBy(xpath=ViewScreenLocators.GET_AMOUNTSENT_FROMTHESEARCH_XPATH)
	WebElement amountsent;
	
	public void gettxtAmountSent()
	{
		Common.waitForElement(driver, amountsent);
		Common.pause(2);
		amuntsent= amountsent.getText().substring(2);
		System.out.println(amuntsent);
	}
	

	@FindBy(xpath=ViewScreenLocators.GET_AMOUNTRECEIVE_FROMTHESEARCH_XPATH)
	WebElement amountReceive;
	
	public void gettxtAmountReceive()
	{
		Common.waitForElement(driver, amountReceive);
		Common.pause(2);
		amuntreceive= amountReceive.getText().substring(2);
		System.out.println(amuntreceive);
	}
	

	@FindBy(xpath=ViewScreenLocators.GET_STATUS_FROMTHESEARCH)
	WebElement transaction_status;
	
	public void gettxtTrsStatus()
	{
		Common.waitForElement(driver, transaction_status);
		Common.pause(2);
		Common.scrollToHorizontal(driver, transaction_status);
		Common.pause(1);
		status= transaction_status.getText();
		System.out.println(status);
	}
	
	@FindBy(xpath=ViewScreenLocators.GET_AMOUNTSENT_FROMVIEWSCREEN_XPATH)
	WebElement viwamountsent;
	
	public void gettxtAmountSentView()
	{
		Common.waitForElement(driver, viwamountsent);
		Common.pause(2);
		amuntsentview= viwamountsent.getText().substring(1);
		System.out.println(amuntsentview);
	}
	
	@FindBy(xpath=ViewScreenLocators.GET_AMOUNTRECEIVE_FROMVIEWSCREEN_XPATH)
	WebElement amountReceiveView;
	
	public void gettxtAmountReceiveView()
	{
		Common.waitForElement(driver, amountReceiveView);
		Common.pause(2);
		amuntreceiveview= amountReceiveView.getText().substring(1);
		System.out.println(amuntreceiveview);
	}
	

	@FindBy(xpath=ViewScreenLocators.GET_STATUS_FROMVIEWSCREEN_XPATH)
	WebElement transaction_statusView;
	
	public void gettxtTrsStatusView()
	{
		Common.waitForElement(driver, transaction_statusView);
		Common.pause(2);
		Common.scrollToVertical(driver, transaction_statusView);
		Common.pause(2);
		statusview= transaction_statusView.getText();
		System.out.println(statusview);
	}
	
	public void verifyAmountsent()
	{
		Boolean amuntse= amuntsent.equalsIgnoreCase(amuntsentview);
		Assert.assertTrue(amuntse,"Amount Sent not matchhed");
	}
	
	public void verifyAmountReceive()
	{
		Boolean amuntre= amuntreceive.equalsIgnoreCase(amuntreceiveview);
		Assert.assertTrue(amuntre,"Amount Receive not matchhed");
	}
	public void verifyTransactionStatus()
	{
		Boolean amuntsts= status.equalsIgnoreCase(statusview);
		Assert.assertTrue(amuntsts,"Amount Sent is  not match");
	}
}
