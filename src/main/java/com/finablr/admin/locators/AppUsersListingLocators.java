package com.finablr.admin.locators;

public class AppUsersListingLocators {
	
	public static final String App_User="(//li[contains(text(),'App Users')])[1]";
	public static final String Select_Filter="(//select[contains(@class,'control select')])[3]";
	public static final String Search="(//input[@placeholder='Search'])[2]";
	public static final String Get_EmailAddress="(//div[@class='transactionWrapper'])[2]//table/tbody/tr/td[3]";

}
