package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class TotalEmails  extends CommonMethods{
	
	@FindBy(xpath="//span[text()='More']")
	List<WebElement> more;
	@FindBy(xpath="//a[text()='All Mail']")
	WebElement all_mails; //10/12
	@FindBy(xpath="//span[@class='Dj']//span/descendant::span[@class='ts']")
	List<WebElement> tmails;  //get 3rd element 
	
	Logger log=LogManager.getLogger(TotalEmails.class);
	public TotalEmails()
	{
		PageFactory.initElements(driver, this);
	}
	public void getTotalEmails()
	{
		log.info("Total Emails ");
		more.get(0).click();
		all_mails.click();
		hardwait(2000);
		String emails=tmails.get(3).getText();
		System.out.println("Total no emails "+emails);
		
		
	}

}
