package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.BlogListingLocators;
import com.finablr.admin.utilities.Common;

public class BlogListingWrapper {
	
	WebDriver driver;
	String Actual_Page_Title="Blog Management";
	String Actual_BlogTitle="What in God’s name is an ISA?";
	String Filter="Category";
	String Category="Business and Finance";
	String pageTitle,blogtitle;
	public static Logger log = LogManager.getLogger(BlogListingWrapper.class);
	
	public BlogListingWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=BlogListingLocators.Blog_LeftSide)
	WebElement blogleft;
	
	@FindBy(xpath=BlogListingLocators.PageTitle)
	WebElement pagetitle;
	
	public void verifyPage()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, blogleft);
		Common.clickableElement(blogleft, driver);
		Common.clickOn(driver, blogleft);
		Common.waitForElement(driver, pagetitle);
		pageTitle=pagetitle.getText().trim();
		System.out.println("Page title is: "+pageTitle);
		Assert.assertTrue(pageTitle.equalsIgnoreCase(Actual_Page_Title), "Title Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=BlogListingLocators.Select_Filter)
	WebElement selectfilter;
	
	@FindBy(xpath=BlogListingLocators.input_filter)
	WebElement enterfilter;
	
	@FindBy(xpath=BlogListingLocators.input_category)
	WebElement entercategory;
	
	@FindBy(xpath=BlogListingLocators.Select_Category)
	WebElement selectcategory;
	
	@FindBy(xpath=BlogListingLocators.Search_textbox)
	WebElement serachtxt;
	
	public void searchBlog()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, enterfilter);
		Common.clickOn(driver, enterfilter);
		enterfilter.sendKeys(Filter);
		Common.pause(2);
		Common.waitForElement(driver, selectfilter);
		Common.clickableElement(selectfilter, driver);
		Common.clickOn(driver, selectfilter);
		Common.pause(2);
		Common.waitForElement(driver, entercategory);
		Common.clickableElement(entercategory, driver);
		Common.clickOn(driver, entercategory);
		entercategory.sendKeys(Category);
		Common.pause(2);
		Common.waitForElement(driver, selectcategory);
		Common.clickableElement(selectcategory, driver);
		Common.clickOn(driver, selectcategory);
		Common.pause(2);
		Common.clickableElement(serachtxt, driver);
		Common.clickOn(driver, serachtxt);
		serachtxt.sendKeys(Actual_BlogTitle);
		//serachtxt.sendKeys(Keys.ENTER);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=BlogListingLocators.Get_BlogTitle)
	WebElement gettitle;
	
	public void verifyTitle()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, gettitle);
		blogtitle=gettitle.getText().trim();
		System.out.println("Blog title is: "+blogtitle);
		Assert.assertTrue(blogtitle.equalsIgnoreCase(Actual_BlogTitle), "Title Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
