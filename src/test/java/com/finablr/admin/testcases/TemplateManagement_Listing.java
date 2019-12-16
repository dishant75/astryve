package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.TemplateManagementWrapper_Listing;

public class TemplateManagement_Listing extends BaseClass {
	
	
	public static Logger log = LogManager.getLogger(LoginPageCases.class);
	
	
	@Test
	
	public void templateListingScreen()
	{
		
		TemplateManagementWrapper_Listing templateWrapper=new TemplateManagementWrapper_Listing(driver);
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		log.info("Click on the Template Management from the Left side Navigation");
		templateWrapper.clkTemplateManagement();
		log.info("Get text from the Code Filed");
		log.info("Get text From the Content Type Field");
		log.info("Scroll upto View icon");
		log.info("Click on the View icon");
		templateWrapper.getTextListing();
		log.info("Get text From the view screen of the Code Field.");
		log.info("Get text From the View Screen of the Content Type Field");
		templateWrapper.getTextViewScreen();
		log.info("Verify Code And Content Type");
		templateWrapper.verifyFields();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
