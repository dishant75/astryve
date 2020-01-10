package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AppUserListingWrapper;

public class AppUserListingCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AppUserListingCases.class);
	
	@Test
	
	public void appUserListingFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		AppUserListingWrapper aw= new AppUserListingWrapper(driver);
		aw.searchUser();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
