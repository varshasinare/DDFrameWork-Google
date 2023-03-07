package com.edusoln.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class ComposeEmail extends CommonMethods{
	
	@FindBy(xpath="//div[@class='T-I T-I-KE L3']")
	WebElement compose;
	@FindBy(xpath="//div[@class='aoI']")
	WebElement new_msg;
	Logger log=LogManager.getLogger(ComposeEmail.class);
	
	public ComposeEmail()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void writeEmail() {
		compose.click();
		hardwait(4000);
		waitForDisplay(new_msg);
		log.info("Email compose working");
		
		
	}

}
