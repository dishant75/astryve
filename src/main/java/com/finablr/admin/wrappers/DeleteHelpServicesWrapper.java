package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.DeleteHelpServiceLocators;
import com.finablr.admin.utilities.Common;

public class DeleteHelpServicesWrapper {
	
	WebDriver driver;
	String deletetext;
	String Actualpopuptext="Are you sure, you want to delete this service?";
	public static Logger log = LogManager.getLogger(DeleteHelpServicesWrapper.class);
	
	public DeleteHelpServicesWrapper(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath=DeleteHelpServiceLocators.Delete_icon)
	WebElement deleteicon;
	
	@FindBy(xpath=DeleteHelpServiceLocators.Delete_popup)
	WebElement deletetxtpopup;
	
	@FindBy(xpath=DeleteHelpServiceLocators.Yes_button)
	WebElement yesbtn;
	
	public void deleteIcon()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.waitForElement(driver, deleteicon);
		Common.clickableElement(deleteicon, driver);
		Common.clickOn(driver, deleteicon);
		Common.pause(2);
		Common.waitForElement(driver, deletetxtpopup);
		deletetext=deletetxtpopup.getText().trim();
		System.out.println("Delete popup text is: "+deletetext);
		Assert.assertTrue(deletetext.equalsIgnoreCase(Actualpopuptext), "Text Doesn't Match");
		Common.waitForElement(driver, yesbtn);
		Common.clickableElement(yesbtn, driver);
		Common.clickOn(driver, yesbtn);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
