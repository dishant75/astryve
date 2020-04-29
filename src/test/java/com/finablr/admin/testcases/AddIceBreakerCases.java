package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddIcebreakerWrapper;

public class AddIceBreakerCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AddIceBreakerCases.class);
	
	@Test
	
	public void addIceBreakerFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To Verify that AddIceBreaker Functionality");
		AddIcebreakerWrapper aw= new AddIcebreakerWrapper(driver);
		aw.verifyPageTitle();
		aw.addIcebreaker();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
