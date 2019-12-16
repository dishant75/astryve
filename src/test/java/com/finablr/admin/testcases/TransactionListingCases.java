package com.finablr.admin.testcases;

import org.testng.annotations.Test;

import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.utilities.Common;
import com.finablr.admin.wrappers.TransactionListingWrapper;

public class TransactionListingCases extends BaseClass {
	
	@Test
	public void transactionListing()
	{
		
		TransactionListingWrapper tw= new TransactionListingWrapper(driver);
		Common.logcase("TC_1 : TO verify Transaction Listing Funactionlaity");
		Common.logstep("Get the Title of the Page and Verify to the Origin.");
		tw.getTitleOfTrlisting();
		Common.logstep("Select the Transaction ID from the Dropdown.");
		tw.selectFilter();
		Common.logstep("Search the via id from the Search box");
		tw.searchArea();
		tw.verifyTID();
	}

}
