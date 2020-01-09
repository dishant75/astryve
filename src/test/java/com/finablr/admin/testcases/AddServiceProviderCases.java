package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddServiceProviderWrapper;

public class AddServiceProviderCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AddServiceProviderCases.class);
	
	@Test
	
	
	public void addProviderFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		AddServiceProviderWrapper aw= new AddServiceProviderWrapper(driver);
		aw.verifyTitle();
		aw.addProvider();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
