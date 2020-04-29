package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.utilities.Common;
import com.finablr.admin.wrappers.TransactionListingWrapper;

public class TransactionListingCases extends BaseClass {
	public static Logger log = LogManager.getLogger(TransactionListingCases.class);
	
	@Test
	public void transactionListing()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("Transaction Listing TestCase");
		TransactionListingWrapper tw= new TransactionListingWrapper(driver);
		Common.logcase("TC_1 : TO verify Transaction Listing Funactionlaity");
		Common.logstep("Get the Title of the Page and Verify to the Origin.");
		tw.getTitleOfTrlisting();
		/*Common.logstep("Select the Transaction ID from the Dropdown.");
		tw.selectFilter();*/
		Common.logstep("Search the via id from the Search box");
		tw.searchArea();
		tw.verifyTID();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
