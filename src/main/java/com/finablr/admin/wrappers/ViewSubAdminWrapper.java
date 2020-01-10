package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.finablr.admin.constants.LogConstants;

public class ViewSubAdminWrapper {
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(SubAdminListingWrapper.class);
	
	public ViewSubAdminWrapper(WebDriver remotedriver) {
		
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
		
	}
	
	
	
	
	public void getSearchDetails()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
