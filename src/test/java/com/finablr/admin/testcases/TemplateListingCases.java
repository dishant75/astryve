package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.TemplateListingWrapper;

public class TemplateListingCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(TemplateListingCases.class);
	
	@Test
	
	public void templateListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		log.info("Verify Page title.");
		TemplateListingWrapper tw= new TemplateListingWrapper(driver);
		tw.verifyPageTitle();
		log.info("Get the Template Code from the Listing");
		tw.templateListing();
		log.info("verify with Actual template Code");
		tw.verifyList();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
