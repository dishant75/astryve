package com.finablr.admin.locators;

//import com.demo.init.SeleniumInit;

public class TransactionListingLocators  {
	
	public static final String MENU_TRANSACTION_LISTING_XPATH= "//h1[contains(text(),'Transaction Listing')]";
	public static final String Select_Classname="(//select[@class='form-control select'])[1]";
	public static final String SEARCH_FILTER_XPATH="(//select[@class='form-control select'])[1]/option[contains(text(),'Transaction ID')]";
	public static final String TXTBOX_SEARCHBAR_XPATH="//input[@class='form-control']";
	public static final String SORTUP_XPATH="//table//th[1]//a[@class=\"sortUp\"]";
	public static final String 	SIDENAVIGATION_TRNSACTIONMANAGEMENT_XPATH="//span[contains(text(),'Transaction Management')]/..";
	public static final String GET_ID_FROMTHESEARCH_XPATH="//table//tr/td[1]/a";

}
