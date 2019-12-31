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
import com.finablr.admin.locators.CategoryListingLocators;
import com.finablr.admin.utilities.Common;

public class CategoryListingWrapper {
	
	WebDriver driver;
	String Header,Categoryresult;
	String Actualtitle="Category Management";
	String Categoryname="Education";
	public static Logger log = LogManager.getLogger(ViewTransactionWrapper.class);
	
	public CategoryListingWrapper(WebDriver remotedriver) {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=CategoryListingLocators.Page_title)
	WebElement pageheader;
	
	@FindBy(xpath=CategoryListingLocators.Category_LeftSide)
	WebElement categoryleft;
	
	public void verifyPageTitle()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.clickableElement(categoryleft, driver);
		Common.clickOn(driver, categoryleft);
		Common.pause(2);
		//Common.waitForElement(driver, pageheader);
		Header= pageheader.getText();
		Common.pause(1);
		Assert.assertTrue(Header.equalsIgnoreCase(Actualtitle),"Title Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}
	
	@FindBy(xpath=CategoryListingLocators.Searchbar)
	WebElement searchbar;
	
	public void searchCategory()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, searchbar);
		Common.clickOn(driver, searchbar);
		searchbar.sendKeys(Categoryname);
		searchbar.sendKeys(Keys.ENTER);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=CategoryListingLocators.Get_Categoryname)
	WebElement getcategory;
	
	public void matchCategory()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, getcategory);
		Common.pause(1);
		Categoryresult=getcategory.getText();
		Common.pause(2);
		Assert.assertTrue(Categoryresult.equalsIgnoreCase(Categoryname), "Result Doesn't Match as per the Search");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
