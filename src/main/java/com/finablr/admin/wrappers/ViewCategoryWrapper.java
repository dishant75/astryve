package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.ViewCategoryLocators;
import com.finablr.admin.utilities.Common;

public class ViewCategoryWrapper {
	
	WebDriver driver;
	String categoryName,contifyId,Pagetitle,viewcategoryname,viewcontifyId;
	public static Logger log = LogManager.getLogger(ViewCategoryWrapper.class);
	
	public ViewCategoryWrapper(WebDriver remotedriver) {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=ViewCategoryLocators.Get_Categoryname)
	WebElement getcategoryname;
	
	@FindBy(xpath=ViewCategoryLocators.Get_ContifyID)
	WebElement getcontifyid;
	
	@FindBy(xpath=ViewCategoryLocators.View_Icon)
	WebElement viewicon;
	
	public void getCategoryDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(2);
		Common.waitForElement(driver, getcategoryname);
		categoryName=getcategoryname.getText();
		System.out.println("Pagetitle is: "+categoryName);
		Common.pause(1);
		contifyId=getcontifyid.getText();
		Common.pause(1);
		System.out.println("Pagetitle is: "+contifyId);
		Common.clickableElement(viewicon, driver);
		Common.clickOn(driver, viewicon);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@FindBy(xpath=ViewCategoryLocators.Page_header)
	WebElement pageheader;
	
	@FindBy(xpath=ViewCategoryLocators.GetView_Categoryname)
	WebElement viewcategory;
	
	@FindBy(xpath=ViewCategoryLocators.GetView_ContifyId)
	WebElement viewcategorycontifyid;
	
	public void getViewPageDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, pageheader);
		Pagetitle=pageheader.getText();
		System.out.println("Pagetitle is: "+Pagetitle);
		Common.waitForElement(driver, viewcategory);
		viewcategoryname= viewcategory.getText();
		Common.pause(2);
		System.out.println("View Category name: "+viewcategoryname);
		viewcontifyId= viewcategorycontifyid.getText();
		Common.pause(1);
		System.out.println("View ContifyId is: "+viewcontifyId);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	public void compareCategoryDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Assert.assertTrue(Pagetitle.equalsIgnoreCase("View Category"), "Title Doesn't Match");
		Common.pause(1);
		Assert.assertTrue(viewcategoryname.equalsIgnoreCase(categoryName), "Category Doesn't match");
		Common.pause(1);
		Assert.assertTrue(viewcontifyId.equalsIgnoreCase(contifyId), "ContifyId Doesn't match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
}
