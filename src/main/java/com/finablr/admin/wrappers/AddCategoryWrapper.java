package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.Constants;
import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddCategoryLocators;
import com.finablr.admin.utilities.Common;

public class AddCategoryWrapper {
	
	WebDriver driver;
	String Pagetitleheader;
	public static Logger log = LogManager.getLogger(AddCategoryWrapper.class);
	
	public AddCategoryWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=AddCategoryLocators.Back_Button)
	WebElement backbutton;
	
	@FindBy(xpath=AddCategoryLocators.AddCategory_Button)
	WebElement addbutton;
	
	@FindBy(xpath=AddCategoryLocators.Categoryname_Textbox)
	WebElement categorytxt;
	
	@FindBy(xpath=AddCategoryLocators.PageHeader)
	WebElement pagetitle;
	
	@FindBy(xpath=AddCategoryLocators.ActiveState_IMG)
	WebElement activestateimg;
	
	@FindBy(xpath=AddCategoryLocators.GreyState_IMG)
	WebElement greyimg;
	
	@FindBy(xpath=AddCategoryLocators.Save_Button)
	WebElement savebtn;
	
	@FindBy(xpath=AddCategoryLocators.Checkbox_blog)
	WebElement checkblog;
	
	@FindBy(xpath=AddCategoryLocators.Categoryname_Textbox)
	WebElement categoryname;
	
	
	public void addDetailsCategory()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Common.clickableElement(backbutton, driver);
		Common.clickOn(driver, backbutton);
		Common.waitForElement(driver, addbutton);
		Common.clickableElement(addbutton, driver);
		Common.pause(1);
		Common.clickOn(driver, addbutton);
		Common.waitForElement(driver, pagetitle);
		Pagetitleheader=pagetitle.getText();
		Common.pause(2);
		System.out.println("Page title is : "+Pagetitleheader);
		Assert.assertTrue(Pagetitleheader.equalsIgnoreCase("Add Category"), "Title Doesn't match");
		Common.pause(2);
		Common.waitForElement(driver, categoryname);
		Common.clickOn(driver, categoryname);
		categoryname.sendKeys("Test Demo");
		//Common.waitForElement(driver, activestateimg);
		activestateimg.sendKeys(Constants.TestData+"News_Topics_Demo.png");
		Common.pause(5);
		greyimg.sendKeys(Constants.TestData+"News_Topics_Education.png");
		Common.pause(5);
		Common.clickableElement(checkblog, driver);
		Common.clickOn(driver, checkblog);
		Common.pause(2);
		Common.clickableElement(savebtn, driver);
		Common.clickOn(driver,savebtn);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
