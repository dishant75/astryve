package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewCategoryWrapper;

public class ViewCategoryCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewCategoryCases.class);
	
	@Test
	
	
	public void viewCategory()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
	    extenttest=extent.createTest("To verify that View Category.");
		ViewCategoryWrapper vc= new ViewCategoryWrapper(driver);
		log.info("Get the All Category Information from the search result:");
		vc.getCategoryDetails();
		log.info("Get All Infromation related to the View Page");
		vc.getViewPageDetails();
		log.info("Verify All the Details");
		vc.compareCategoryDetails();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
 
}
