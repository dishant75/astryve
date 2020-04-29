package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddCountryServiceWrapper;

public class AddCountryServiceCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AddCountryServiceCases.class);
	
	@Test
	
	public void addServices()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest= extent.createTest("To Verify that Add Country Service Test Case.");
		AddCountryServiceWrapper ac= new AddCountryServiceWrapper(driver);
		ac.verifyPageTitle();
		ac.addCountryService();
		ac.verifyCountry();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
