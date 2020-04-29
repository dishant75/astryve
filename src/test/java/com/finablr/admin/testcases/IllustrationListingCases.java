package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.IllustrationListingWrapper;

public class IllustrationListingCases extends BaseClass {
	public static Logger log = LogManager.getLogger(IllustrationListingCases.class);
	
	@Test
	
	public void illustrationListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest= extent.createTest("To Verify that Illustration Listing Scenario.");
		IllustrationListingWrapper iw= new IllustrationListingWrapper(driver);
		iw.navigateIllustrationPage();
		iw.illustartionListing();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
