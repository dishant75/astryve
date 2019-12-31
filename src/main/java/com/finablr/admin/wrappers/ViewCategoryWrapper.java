package com.finablr.admin.wrappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.finablr.admin.constants.LogConstants;

public class ViewCategoryWrapper {
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(ViewTransactionWrapper.class);
	
	public ViewCategoryWrapper(WebDriver remotedriver) {
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}
}
