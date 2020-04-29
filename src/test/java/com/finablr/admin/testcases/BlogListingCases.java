package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.BlogListingWrapper;

public class BlogListingCases extends BaseClass {
	public static Logger log = LogManager.getLogger(BlogListingWrapper.class);
	
	@Test
	
	public void blogListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To Verify that Blog Listing Screen.");
		BlogListingWrapper bw= new BlogListingWrapper(driver);
		bw.verifyPage();
		bw.searchBlog();
		bw.verifyTitle();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
