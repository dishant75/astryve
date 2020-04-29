package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewAppUserWrapper;

public class ViewAppUserCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewAppUserCases.class);
	
	@Test
	
	public void viewAppUserFunctionality()
	{
		
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To verify that ViewAppUser Functionality");
		ViewAppUserWrapper vw= new ViewAppUserWrapper(driver);
		vw.getSearchDetails();
		vw.getViewDetails();
		vw.compareValues();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
