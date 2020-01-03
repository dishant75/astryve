package com.finablr.admin.locators;

public class ViewTemplateLocators {
	
	public static final String Get_TemplateCode="//table/tbody/tr/td[1]";
	public static final String Get_Title="//table/tbody/tr/td[2]";
	public static final String Get_Channel="//table/tbody/tr/td[3]";
	public static final String Get_EffectivefromDate="//table/tbody/tr/td[4]";
	public static final String Get_EffectiveTillDate="//table/tbody/tr/td[5]";
	public static final String Get_ViewCode="//span[contains(text(),'Code')]/following::div[1]/span";
	public static final String Get_Viewtitle="//span[contains(text(),'Name')]/following::div[1]/span";
	public static final String Get_ViewChannel="//span[contains(text(),'Channel')]/following::div[1]/span";
	public static final String Get_ViewEffectiveFrom="//span[contains(text(),'Effective From')]/following::div[1]/span";
	public static final String Get_ViewEffectiveTill="//span[contains(text(),'Effective Till')]/following::div[1]/span";
	
}
