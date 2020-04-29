package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.finablr.admin.constants.LogConstants;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.wrappers.DeleteHelpServicesWrapper;

public class DeleteHelpServicesCases extends BaseClass {
	
	public static Logger log = LogManager.getLogger(DeleteHelpServicesCases.class);
	
	@Test
	
	public void deleteHelpServices()
	{
		log.info(LogConstants.LOG_ENTER+Thread.currentThread().getStackTrace()[1].getMethodName());
		extenttest=extent.createTest("To verify Delete Help Services Functionality");
		DeleteHelpServicesWrapper dw= new DeleteHelpServicesWrapper(driver);
		dw.deleteIcon();
		log.info(LogConstants.LOG_EXIT+Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
