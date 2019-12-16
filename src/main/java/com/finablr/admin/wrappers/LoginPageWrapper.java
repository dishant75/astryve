package com.finablr.admin.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finablr.admin.locators.LoginPageLocators;
import com.finablr.admin.utilities.Common;

public class LoginPageWrapper {

	WebDriver driver;

	public LoginPageWrapper(WebDriver remotedriver) {
		driver = remotedriver;
		PageFactory.initElements(remotedriver, this);
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

//	Method to enter the Username
	public void enterUsername(String uname) {
		/*Common.pause(3);*/
		Common.waitForElement(driver, txtboxUsername);
		txtboxUsername.sendKeys(uname);
	}

//	Method to enter the Password
	public void enterPassword(String pword) {
		txtboxPassword.sendKeys(pword);
		Common.pause(2);
	}

//	Method to click the Login button
	public void clickLogin() {
		Common.pause(1);
		btnLogin.click();
		Common.pause(2);
		
		
	}
	
	/*public void checkRemeberMe()
	{
		chkbox_remember_me.click();
	}*/
	
	public void clickForgotPassword() {
		chkbox_forgot_password.click();
		txtboxUsername.sendKeys("rutul.modi@peaas.co");
		
	}

}
