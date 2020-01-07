package com.finablr.admin.locators;

public class ViewTransactionLocators {
	public static final String Select_Classname="(//select[@class='form-control select'])[1]";
	public static final String Select_Service="//option[contains(text(),'Select Service')]/..";
	public static final String Get_TID="//div[@class='tablewrapper green']/table/tbody/tr[1]/td[1]/a";
	public static final String Get_Amount="//div[@class='tablewrapper green']/table/tbody/tr[1]/td[3]";
	public static final String Get_Status="//div[@class='tablewrapper green']/table/tbody/tr[1]/td[5]/span";
	public static final String Get_TransactionID="//h2[contains(text(),'Transaction Id :')]";
	public static final String Get_ViewStatus="(//p[text()='Status']//following::span)[1]";
	public static final String Get_SendMoney="(//p[text()='Amount sent']//following::p)[1]";

}
