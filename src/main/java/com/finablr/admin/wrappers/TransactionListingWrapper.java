package com.finablr.admin.wrappers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.finablr.admin.locators.TransactionListingLocators;
//import com.demo.init.AbstractPage;
//import com.finablr.admin.locators.TransactionListingLocators;
import com.finablr.admin.utilities.Common;

public class TransactionListingWrapper  {

	WebDriver driver;

	public TransactionListingWrapper(WebDriver remotedriver) {
		// TODO Auto-generated constructor stub
		
		driver= remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	@FindBy(xpath=TransactionListingLocators.MENU_TRANSACTION_LISTING_XPATH)
	WebElement title;

	public void getTitleOfTrlisting() {
		String origin = "Transaction Listing";
		Common.waitForElement(driver, title);
		String s1 = title.getText();
		Common.pause(1);
		if (s1.equalsIgnoreCase(origin)) {
			System.out.println("Transaction Management Title Match");

		} 
		else 
		{
			System.out.println("Text doesn't Match");
		}

	}
	@FindBy(xpath=TransactionListingLocators.Select_Classname)
	WebElement drpdownTransaction;
	
	public void selectFilter()
	{
		Common.pause(3);
		Select select= new Select(drpdownTransaction);
		Common.pause(2);
		select.selectByIndex(1);
	}
	
	@FindBy(xpath=TransactionListingLocators.TXTBOX_SEARCHBAR_XPATH)
	WebElement searchareatxt;
	public void searchArea()
	{
		Common.pause(2);
		Common.clickOn(driver, searchareatxt);
		Common.type(searchareatxt, "1366789001");
		searchareatxt.sendKeys(Keys.ENTER);
	}
	@FindBy(xpath=TransactionListingLocators.GET_ID_FROMTHESEARCH_XPATH)
	WebElement getid;
	
	public void verifyTID()
	{
		Common.pause(2);
		String id= getid.getText();
		Common.pause(2);
		if (id.equalsIgnoreCase("1366789001")) {
			System.out.println("ID match");
			
		} else {
			System.out.println("ID doesn't match");

		}
	}


}
