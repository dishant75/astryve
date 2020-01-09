package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.finablr.admin.constants.Constants;
import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.AddBlogLocators;
import com.finablr.admin.utilities.Common;

public class AddBlogWrapper {
	
	WebDriver driver;
	String Actual_Title="Create Blog";
	String getHeader;
	String Blog_Title="Test Demo";
	String blog_content="Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains, Here,I saved you a seat.Even on these old electric trains";
	public static Logger log = LogManager.getLogger(AddBlogWrapper.class);
	
	public AddBlogWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	
	@FindBy(xpath=AddBlogLocators.Add_btn)
	WebElement addbtn;
	
	
	@FindBy(xpath=AddBlogLocators.header)
	WebElement Pageheader;
	
	
	public void verifyPageTitle()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, addbtn);
		Common.clickableElement(addbtn, driver);
		Common.clickOn(driver, addbtn);
		Common.waitForElement(driver, Pageheader);
		getHeader=Pageheader.getText().trim();
		System.out.println("Page header is: "+getHeader);
		Assert.assertTrue(getHeader.equalsIgnoreCase(Actual_Title), "Title Doesn't Match");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	@FindBy(xpath=AddBlogLocators.input_title)
	WebElement inputTitle;
	
	@FindBy(xpath=AddBlogLocators.select_category)
	WebElement selectCategory;
	
	@FindBy(xpath=AddBlogLocators.blog_Content)
	WebElement blogContent;
	
	@FindBy(xpath=AddBlogLocators.Blog_Color)
	WebElement backgroundColor;
	
	@FindBy(xpath=AddBlogLocators.upload_img)
	WebElement img;
	
	@FindBy(xpath=AddBlogLocators.Publish_btn)
	WebElement publishbtn;
	
	
	public void addBlog()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, inputTitle);
		Common.clickableElement(inputTitle, driver);
		Common.clickOn(driver, inputTitle);
		inputTitle.sendKeys(Blog_Title);
		Common.pause(2);
		Select select= new Select(selectCategory);
		select.selectByIndex(1);
		Common.pause(1);
		Common.waitForElement(driver, blogContent);
		Common.clickableElement(blogContent, driver);
		Common.clickOn(driver, blogContent);
		blogContent.sendKeys(blog_content);
		Common.pause(1);
		Common.waitForElement(driver, backgroundColor);
		Common.clickableElement(backgroundColor, driver);
		Common.clickOn(driver, backgroundColor);
		//Common.waitForElement(driver, img);
		img.sendKeys(Constants.TestData+"blog.png");
		Common.pause(1);
		Common.waitForElement(driver, publishbtn);
		Common.clickableElement(publishbtn, driver);
		Common.clickOn(driver, publishbtn);
		Common.pause(2);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}

}
