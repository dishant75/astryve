package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewTemplateWrapper;

public class ViewTemplateCases extends BaseClass {
	public static Logger log = LogManager.getLogger(ViewTemplateCases.class);
	
	@Test
	
	public void viewTemplate()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		ViewTemplateWrapper vw= new ViewTemplateWrapper(driver);
		log.info("Get the All Listing page details");
		vw.getListingDetails();
		log.info("Get the All View page details");
		vw.getViewDetails();
		log.info("Get the All View page details");
		vw.verifyViewTemplateData();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}

}
