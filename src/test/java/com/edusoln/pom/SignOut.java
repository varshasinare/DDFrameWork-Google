package com.edusoln.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class SignOut extends CommonMethods{
	
	@FindBy(xpath="//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img")
	WebElement account_logo;
	@FindBy(xpath="//a[@class='V5tzAf h2rKjc jFfZdd OtBgcb']")
	WebElement sign_out;
	
	Logger log=LogManager.getLogger(SignOut.class);
	public SignOut()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logOut()
	{
		
		account_logo.click();
		driver.switchTo().frame("account");
		waitForDisplay(sign_out);
		hardwait(2000);
		sign_out.click();
		log.info("Gmail sign out");
		hardwait(5000);
	}

}
