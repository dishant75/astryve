package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.ViewSubAdminWrapper;

public class ViewSubAdminCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(ViewSubAdminCases.class);
	
	@Test
	
	public void viewSubadminFunctionality()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		ViewSubAdminWrapper vw= new ViewSubAdminWrapper(driver);
		vw.getSearchDetails();
		vw.viewdetails();
		vw.veirfyResult();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
