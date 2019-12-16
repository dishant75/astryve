package com.finablr.admin.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.utilities.ReadPropertiesFile;

import com.finablr.admin.wrappers.SubAdminWrapper;

public class SubAdminCases extends BaseClass {

	public static Logger log = LogManager.getLogger(LoginPageCases.class);
	
	@Test
	public void filterSearchSubadmin() throws InterruptedException
	{
		SubAdminWrapper sp = new SubAdminWrapper(driver);
		sp.clickMenuusermanagement();
		log.info("clicks on usermanagement tab");
//		sp.clickSubadminBTN();
//		log.info("click on subadmin btn");
		Thread.sleep(2000);
		sp.clickFilter();
		log.info("click on filter");
		sp.selectfilter_Firstname();
		Thread.sleep(2000);
		log.info("select firstname from filter");
		sp.enterSearchvalue();
		log.info("enter firstname data");
		sp.pressEnter();
		log.info("press enter button");

	}

}
