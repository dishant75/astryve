package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.utilities.ReadPropertiesFile;
import com.finablr.admin.wrappers.LoginPageWrapper;

public class LoginPageCases extends BaseClass {

	public static Logger log = LogManager.getLogger(LoginPageCases.class);
	
	/*
	@Test
	public void loginApplication1() {
		LoginPageWrapper lp = new LoginPageWrapper(driver);
		

		lp.clickLogin();
		
	}*/

	@Test
	public void loginApplication2() {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		LoginPageWrapper lp = new LoginPageWrapper(driver);
		lp.enterUsername(ReadPropertiesFile.getProperty("username"));
		log.info("Entered the Correct Username");
		lp.enterPassword("bloma@123");
		log.info("Entered the Correct Password");
		lp.clickLogin();
		log.info("Clicked on Login Button");
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
