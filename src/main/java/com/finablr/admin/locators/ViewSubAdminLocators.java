package com.finablr.admin.locators;

public class ViewSubAdminLocators {
	
	public static final String Get_EmailAddress="(//div[@class='transactionWrapper'])[1]//table/tbody/tr/td[3]";
	public static final String Get_Fullname="(//div[@class='transactionWrapper'])[1]//table/tbody/tr/td[1]/a";
	public static final String Get_Role="(//div[@class='transactionWrapper'])[1]//table/tbody/tr/td[2]";
	public static final String View_Role="//span[contains(text(),'Role')]//following::span[1]/input";
	public static final String View_Email="//span[contains(text(),'Email Address')]//following::span[1]/input";
	public static final String View_FirstName="//span[contains(text(),'First Name')]//following::span[1]/input";
	public static final String View_Lastname="//span[contains(text(),'Last Name')]//following::span[1]/input";

}
