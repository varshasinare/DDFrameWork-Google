package com.edusoln.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class Settings extends CommonMethods{
	
	@FindBy(xpath="//a[@aria-label='Settings']")
	WebElement set_link;
	@FindBy(xpath="//button[@aria-label='See all settings']")
	WebElement see_all_setting;
	@FindBy(xpath="//h2[text()='Settings']")
	WebElement setting;
	
	Logger log=LogManager.getLogger(Settings.class);
	public Settings()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkSettings()
	{
		waitForDisplay(set_link);
		set_link.click();
		hardwait(2000);
		see_all_setting.click();
		hardwait(2000);
		waitForDisplay(setting);
		log.info("Settings on Gmail are present");
		
		
	}
}
