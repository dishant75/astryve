package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewCategoryWrapper;

public class ViewCategoryCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewTransactionCases.class);
	
	@Test
	
	
	public void viewCategory()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		ViewCategoryWrapper vc= new ViewCategoryWrapper(driver);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
