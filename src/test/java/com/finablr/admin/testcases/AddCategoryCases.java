package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddCategoryWrapper;

public class AddCategoryCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AddCategoryCases.class);
	
	@Test
	
	public void addCategory()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		AddCategoryWrapper aw= new AddCategoryWrapper(driver);
		aw.addDetailsCategory();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
