package com.finablr.admin.testcases;

import org.testng.annotations.Test;

import com.finablr.admin.utilities.BaseClass;
import com.finablr.admin.utilities.Common;
import com.finablr.admin.wrappers.ViewScreenWrapper;

public class ViewScreenCases extends BaseClass {
	
	@Test
	
	public void viewscreen()
	{
		ViewScreenWrapper vw= new ViewScreenWrapper(driver);
		Common.logcase("To Verfiy View Screen of Transaction management:");
		Common.log("Get text from the Amount Sent:");
		vw.gettxtAmountSent();
		Common.log("Get text from the Amount Receive:");
		vw.gettxtAmountReceive();
		Common.log("Get Transaction Status:");
		vw.gettxtTrsStatus();
		Common.log("Scroll to the View Screen icon");
		vw.clkviewIcon();
		Common.log("Get Amount Sent from the View Screen");
		vw.gettxtAmountSentView();
		Common.log("Get text from the Amount receive from the View Screen");
		vw.gettxtAmountReceiveView();
		Common.log("Get status from the View Screen");
		vw.gettxtTrsStatusView();
		Common.log("Verify Amunt sent Match");
		vw.verifyAmountsent();
		Common.log("Verify Amount Receive match");
		vw.verifyAmountReceive();
		Common.log("Verify Transaction Status Match");
		vw.verifyTransactionStatus();
	}

}
