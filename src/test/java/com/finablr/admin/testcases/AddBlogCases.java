package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.AddBlogWrapper;

public class AddBlogCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(AddBlogCases.class);
	
	@Test
	
	public void addBlogFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To verify that Add Blog Functionality");
		AddBlogWrapper aw= new AddBlogWrapper(driver);
		aw.verifyPageTitle();
		aw.addBlog();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
