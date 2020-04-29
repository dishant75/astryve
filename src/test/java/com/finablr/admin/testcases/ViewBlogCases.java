package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewBlogWrapper;

public class ViewBlogCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewBlogCases.class);
	
	@Test
	
	
	public void viewBlogFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To Verify that View Blog Functionality");
		ViewBlogWrapper vw= new ViewBlogWrapper(driver);
		vw.getSearchresult();
		vw.getViewDetails();
		vw.compareDetails();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
