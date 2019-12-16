package com.finablr.admin.locators;

public class SubAdminLocators {

	//subadmin listing screen xpath
	
		public static final String MENU_USER_MANAGEMENT_XPATH = "//span[@class='navTitle'][contains(text(),'User Management')]";
		public static final String BTN_SUBADMIN = "(//div[@class='tabSection']//li[@class='active'])[1]";
		public static final String BTN_APPUSER = "(//div[@class='tabSection']//li[@class='active'])[2]";
		public static final String BTN_ADD_SUBADMIN_XPATH = "//button[contains(text(),' Add Sub-Admin')]";
		public static final String BTN_SUBADMIN_XPATH = "//li[@class='active'][contains(text(),'Sub Admin')]";
		public static final String BTN_APPUSER_XPATH = "//li[@class='active'][contains(text(),'App Users')]";
		public static final String DRPDWN_FILTER = "(//div[@class='mainWrapper']//select)[1]";
		public static final String FILTER_FIRSTNAME_XPATH = "(//div[@class='mainWrapper']//select)[1]/option[@name='First Name']";
		public static final String SEARCH_BOX_XPATH = "(//div[@class='mainWrapper']//input)[1]";
		public static final String EXPORT_EXCEL_XPATH = "(//div[@class='mainWrapper']//div[@class='fileSection'])[1]/a[@class='file-item excel']";
		public static final String EXPORT_PDF_XPATH = "(//div[@class='mainWrapper']//div[@class='fileSection'])[1]/a[@class='file-item pdf']";
		public static final String DRPDWN_NUMBER_OF_RECORDS_15_XPATH = "(//div[@class='mainWrapper']//select)[2]/option[@name='15']";
		public static final String BTN_VIEW_XPATH = "(//div[@class='mainWrapper']//span)[11]";
		
		
		//view subadmin screen
		
		public static final String LBL_VIEW_SUBADMIN_XPATH = "//div[@class='viewHeader']/h2";
		public static final String BTN_BACK_XPATH = "(//button[@class='btn btn-primary'])[1]";
		public static final String LBL_FIRST_NAME_XPATH = "//div[@class='viewAdminDetails']/span[contains(text(),'First Name')]";
		public static final String LBL_lAST_NAME_XPATH = "//div[@class='viewAdminDetails']/span[contains(text(),'Last Name')]";
		public static final String LBL_EMAIL_ADDRESS_XPATH = "//div[@class='viewAdminDetails']/span[contains(text(),'Email Address')]";
		public static final String LBL_COUNTRY_CODE_XPATH = "//div[@class='viewAdminDetails mobileNumber']/span[contains(text(),'Country Code')]";
		public static final String LBL_MOBILE_NUMBER_XPATH = "//div[@class='viewAdminDetails mobileNumber']/span[contains(text(),'Mobile Number')]";
		public static final String LBL_ROLE_XPATH = "//div[@class='viewAdminDetails']/span[contains(text(),'Role')]";
		public static final String LBL_STATUS_XPATH = "//div[@class='viewAdminDetails']/span[contains(text(),'Status')]";
		public static final String TXT_FIRST_NAME_XPATH = "//input[@name='firstName']";
		public static final String TXT_LAST_NAME_XPATH = "//input[@name='lastName']";
		public static final String TXT_EMAIL_XPATH = "//input[@name='email']";
		public static final String DRPDWN_COUNTRY_XPATH = "//input[@name='countryCode']";
		public static final String DRPDWN_MOBILE_NUMBER_XPATH = "//input[@name='mobileNumber']";
		public static final String DRPDWN_ROLE_XPATH = "//input[@name='role']";
		public static final String DRPDWN_STATUS_XPATH = "//input[@name='status']";
		public static final String BTN_EDIT_XPATH = "//div[@class='publishButton customButton']/button";
		public static final String BTN_CANCLE_XPATH = "//div[@class='cancelButton customButton black']/button";
		public static final String BTN_SAVE_XPATH = "//div[@class='saveButton customButton']/button";
		
}
