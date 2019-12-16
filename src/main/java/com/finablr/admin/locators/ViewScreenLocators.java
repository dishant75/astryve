package com.finablr.admin.locators;

public class ViewScreenLocators {
	
	public static final String VIEW_ICON_XPATH= "//a[@class='edit actionIcon']";
	public static final String STATUS_OF_TRANSACTION_XPATH="//div[@class=\"details\"]/span[contains(text(),'Order Booked')]";
	public static final String GET_TID_XPATH="//div[@class=\"transactionDetailsWrapper\"]//h1";
	public static final String GET_STATUS_XPATH="//label[contains(text(),'Status')]/following-sibling::span";
	public static final String GET_ID_FROMTHESEARCH_XPATH="//table//tr/td[1]";
	public static final String GET_STATUS_FROMTHESEARCH="//table//tr/td[7]/span";
	public static final String GET_AMOUNTSENT_FROMTHESEARCH_XPATH="//table//tr/td[3]";
	public static final String GET_AMOUNTRECEIVE_FROMTHESEARCH_XPATH="//table//tr/td[4]";
	public static final String GET_AMOUNTSENT_FROMVIEWSCREEN_XPATH="//div[@class='amountSent']/p[@class='info']";
	public static final String GET_AMOUNTRECEIVE_FROMVIEWSCREEN_XPATH="//div[@class='amountRecevied']/p[@class='info']";
	public static final String GET_STATUS_FROMVIEWSCREEN_XPATH="//p[contains(text(),'Status')]//following::p/span";
}
