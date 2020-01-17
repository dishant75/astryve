package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.locators.LoginPageLocators;
import com.finablr.admin.utilities.Common;

public class LoginPageWrapper {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(LoginPageWrapper.class);

	
	public LoginPageWrapper(WebDriver remotedriver) {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
	driver = remotedriver;
		PageFactory.initElements(remotedriver, this);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@FindBy(id = LoginPageLocators.TXTBOX_USERNAME_ID)
	WebElement txtboxUsername;

	@FindBy(id = LoginPageLocators.TXTBOX_PASSWORD_ID)
	WebElement txtboxPassword;

	@FindBy(xpath = LoginPageLocators.BTN_LOGIN_XPATH)
	WebElement btnLogin;
	
	@FindBy(xpath = LoginPageLocators.CHKBOX_REMEMBERME_XPATH)
	WebElement chkbox_remember_me;
	
	@FindBy(xpath = LoginPageLocators.LINK_FORGOTPASSWORD_XPATH)
	WebElement chkbox_forgot_password;
	
	@FindBy(xpath=LoginPageLocators.Username_Xpath)
	WebElement username;

//	Method to enter the Username
	public void enterUsername(String uname) {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		/*Common.pause(3);*/
		Common.waitForElement(driver, txtboxUsername);
		txtboxUsername.sendKeys(uname);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

//	Method to enter the Password
	public void enterPassword(String pword) {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		txtboxPassword.sendKeys(pword);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

//	Method to click the Login button
	public void clickLogin() {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		Common.pause(1);
		Common.clickableElement(btnLogin, driver);
		btnLogin.click();
		Common.pause(2);
		Common.waitForElement(driver, username);
		Common.pause(1);
		String getuname=username.getText();
		System.out.println("User name is: "+getuname);
		Common.pause(1);
		Assert.assertTrue(getuname.equalsIgnoreCase("Hello Beta User"));
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());	
	}
	
	/*public void checkRemeberMe()
	{
		chkbox_remember_me.click();
	}*/
	
	public void clickForgotPassword() {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		chkbox_forgot_password.click();
		txtboxUsername.sendKeys("rutul.modi@peaas.co");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
