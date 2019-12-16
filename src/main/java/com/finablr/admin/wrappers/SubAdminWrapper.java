package com.finablr.admin.wrappers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.finablr.admin.utilities.Common;
import com.finablr.admin.locators.SubAdminLocators;

public class SubAdminWrapper {

	WebDriver localdriver;

	public SubAdminWrapper(WebDriver remotedriver) {

		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);

	}

	// listing screen subadmin

	@FindBy(xpath = SubAdminLocators.MENU_USER_MANAGEMENT_XPATH)
	WebElement menuusermanagement;

	@FindBy(xpath = SubAdminLocators.BTN_SUBADMIN)

	WebElement btn_subadmin;

	@FindBy(xpath = SubAdminLocators.DRPDWN_FILTER)
	WebElement DRPDWN_FILTER;

	@FindBy(xpath = SubAdminLocators.FILTER_FIRSTNAME_XPATH)
	WebElement filter_firstname;

	@FindBy(xpath = SubAdminLocators.SEARCH_BOX_XPATH)
	WebElement searchbox;

	@FindBy(xpath = SubAdminLocators.BTN_VIEW_XPATH)
	WebElement btnview;

	// view screen subadmin

	@FindBy(xpath = SubAdminLocators.LBL_VIEW_SUBADMIN_XPATH)
	WebElement viewSubadminLBL;

	@FindBy(xpath = SubAdminLocators.LBL_FIRST_NAME_XPATH)
	WebElement lbl_firstname;

	@FindBy(xpath = SubAdminLocators.LBL_lAST_NAME_XPATH)
	WebElement lbl_lastname;

	@FindBy(xpath = SubAdminLocators.LBL_EMAIL_ADDRESS_XPATH)
	WebElement lbl_email;

	@FindBy(xpath = SubAdminLocators.LBL_COUNTRY_CODE_XPATH)
	WebElement lbl_country;

	@FindBy(xpath = SubAdminLocators.LBL_MOBILE_NUMBER_XPATH)
	WebElement lbl_mobileNo;

	@FindBy(xpath = SubAdminLocators.LBL_ROLE_XPATH)
	WebElement lbl_role;

	@FindBy(xpath = SubAdminLocators.LBL_STATUS_XPATH)
	WebElement lbl_status;

	@FindBy(xpath = SubAdminLocators.TXT_FIRST_NAME_XPATH)
	WebElement txt_fname;

	@FindBy(xpath = SubAdminLocators.TXT_LAST_NAME_XPATH)
	WebElement txt_lname;

	@FindBy(xpath = SubAdminLocators.TXT_EMAIL_XPATH)
	WebElement txt_email;

	@FindBy(xpath = SubAdminLocators.DRPDWN_COUNTRY_XPATH)
	WebElement drpdwn_country;

	@FindBy(xpath = SubAdminLocators.DRPDWN_MOBILE_NUMBER_XPATH)
	WebElement drpdwn_mobile_no;

	@FindBy(xpath = SubAdminLocators.DRPDWN_ROLE_XPATH)
	WebElement drpdwn_role;

	@FindBy(xpath = SubAdminLocators.DRPDWN_STATUS_XPATH)
	WebElement drpdwn_status;

	@FindBy(xpath = SubAdminLocators.BTN_EDIT_XPATH)
	WebElement btn_edit;

	@FindBy(xpath = SubAdminLocators.BTN_SAVE_XPATH)
	WebElement btn_save;

	@FindBy(xpath = SubAdminLocators.BTN_BACK_XPATH)
	WebElement btn_back;

	// Method to click on usermanagement tab
	public void clickMenuusermanagement() throws InterruptedException {
		Thread.sleep(2000);
		Common.clickOn(localdriver, menuusermanagement);

	}

	// method to click on subadmin btn
	public void clickSubadminBTN() {

		Common.clickOn(localdriver, btn_subadmin);
	}

	// method to click on filter
	public void clickFilter() {
		Common.clickOn(localdriver, DRPDWN_FILTER);
	}

	// method to select filter value as first name

	public void selectfilter_Firstname() {
		Common.selectFromComboByVisibleText(filter_firstname, "First Name");

	}

	// method to enter data in serach box

	public void enterSearchvalue() {
		Common.type(searchbox, "abcd");

	}

	// method to press enter

	public void pressEnter() {
		searchbox.sendKeys(Keys.ENTER);
	}

	// method to click on view icon

	public void clickViewBtn() {
		btnview.click();
		Common.clickOn(localdriver, btnview);
	}
}
