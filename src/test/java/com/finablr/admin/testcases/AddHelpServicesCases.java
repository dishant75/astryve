package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddHelpServicesWrapper;

public class AddHelpServicesCases extends BaseClass {
	public static Logger log = LogManager.getLogger(AddHelpServicesCases.class);
	
	@Test
	
	public void addservice() {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To verify that Add help Services Functionality.");
		AddHelpServicesWrapper aw= new AddHelpServicesWrapper(driver);
		aw.helpserviceListing();
		aw.addhelpService();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
