package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddIllustrationWrapper;

public class AddIllustrationCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AddIllustrationCases.class);
	
	@Test
	
	public void addIllustrationFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest= extent.createTest("To verify that Add Illustration Scenario.");
		AddIllustrationWrapper ai= new AddIllustrationWrapper(driver);
		ai.addEvent();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
