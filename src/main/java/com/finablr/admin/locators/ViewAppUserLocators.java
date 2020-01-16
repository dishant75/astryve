package com.finablr.admin.locators;

public class ViewAppUserLocators {
	
	public static final String Get_EmailAddress="(//div[@class='transactionWrapper'])[2]//table/tbody/tr/td[3]";
	public static final String Get_FullName="(//div[@class='transactionWrapper'])[2]//table/tbody/tr/td[1]/a";
	public static final String Get_Mobile_Number="(//div[@class='transactionWrapper'])[2]//table/tbody/tr/td[2]";
	public static final String Get_KYC_Status="(//div[@class='transactionWrapper'])[2]//table/tbody/tr/td[4]/span";
	public static final String Get_View_Fullname="//span[contains(text(),'Full Name')]//following::span[1]/input";
	public static final String Get_View_Email="//span[contains(text(),'Email')]//following::span[1]/input";
	public static final String Get_View_MobileNumber="//span[contains(text(),'Mobile Number')]//following::span[1]/input";
	public static final String Get_View_KYC_Status="//span[contains(text(),'KYC')]//following::span[1]/input";
	public static final String Get_Header="//h2";

}
