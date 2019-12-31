package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewTransactionWrapper;

public class ViewTransactionCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewTransactionCases.class);
	
	@Test
	
	public void viewTransaction()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		ViewTransactionWrapper vw= new ViewTransactionWrapper(driver);
		log.info("Select Service from the First Dropdwon");
		vw.selectFilter();
		log.info("Select Gifting from the First Dropdwon");
		vw.selectService();
		log.info("Get All the Needed text and Click on the Transaction Id of the First Row from the List");
		vw.getInfo();
		log.info("Get All the Needed text from the View page");
		vw.getviewElements();
		log.info("Compare All the Texts");
		vw.verifyelements();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
