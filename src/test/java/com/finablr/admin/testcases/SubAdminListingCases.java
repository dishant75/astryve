package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.SubAdminListingWrapper;

public class SubAdminListingCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(SubAdminListingCases.class);
	
	@Test
	
	public void subAdminListingFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		SubAdminListingWrapper sw= new SubAdminListingWrapper(driver);
		sw.searchUser();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
