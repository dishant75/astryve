package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.CategoryListingWrapper;

public class CategoryListingCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewTransactionCases.class);
	
	@Test
	
	public void categoryListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		CategoryListingWrapper cl= new CategoryListingWrapper(driver);
		log.info("Verify the Page Title");
		cl.verifyPageTitle();
		log.info("Search for the Specific Category");
		cl.searchCategory();
		log.info("Verify the Search Result");
		cl.matchCategory();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
