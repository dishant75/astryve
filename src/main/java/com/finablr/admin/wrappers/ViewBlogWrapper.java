package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.ViewBlogLocators;
import com.finablr.admin.utilities.Common;

public class ViewBlogWrapper {
	
	WebDriver driver;
	String getTitle,getViewTitle,getCategory,getViewCategory;
	public static Logger log = LogManager.getLogger(ViewBlogWrapper.class);
	public ViewBlogWrapper(WebDriver remotedriver)
	{
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=ViewBlogLocators.Get_BlogTitle)
	WebElement gettitle;
	
	
	@FindBy(xpath=ViewBlogLocators.Get_Category)
	WebElement getcategory;
	
	
	public void getSearchresult()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, gettitle);
		getTitle=gettitle.getText().trim();
		System.out.println("Blog Title in Result page: "+getTitle);
		Common.waitForElement(driver, getcategory);
		getCategory=getcategory.getText().trim();
		System.out.println("Blog Category in Result page: "+getCategory);
		Common.clickableElement(gettitle, driver);
		Common.clickOn(driver, gettitle);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=ViewBlogLocators.Get_viewTitle)
	WebElement viewtitle;
	
	@FindBy(xpath=ViewBlogLocators.Get_viewCategory)
	WebElement viewcategory;
	
	
	public void getViewDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, viewtitle);
		getViewTitle=viewtitle.getText().trim();
		System.out.println("Blog Title in Result page: "+getTitle);
		Common.waitForElement(driver, viewcategory);
		getViewCategory=viewcategory.getText().trim();
		System.out.println("Blog Category in Result page: "+getViewCategory);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	public void compareDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Assert.assertTrue(getViewTitle.equalsIgnoreCase(getTitle), "Title Differ from each other.");
		Assert.assertTrue(getViewCategory.equalsIgnoreCase(getCategory), "Categories are differ from each other");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
