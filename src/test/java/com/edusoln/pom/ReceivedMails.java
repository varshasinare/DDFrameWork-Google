package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class ReceivedMails extends CommonMethods{
	
	@FindBy(xpath="//div[@class='TN bzz aHS-bnu']")
	WebElement sent;
	@FindBy(xpath="//input[@aria-label='Search mail']")
	WebElement search_mail;
	@FindBy(xpath="//span[@class='Dj']//span/descendant::span[@class='ts']")
	List<WebElement> tmails;  //get 3rd element 
	
	Logger log=LogManager.getLogger(ReceivedMails.class);
	
	public ReceivedMails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkReceivedMail()
	{
		log.info("Checking received mail");
		search_mail.clear();
		search_mail.sendKeys("varshah.holkar@gmail.com");
		search_mail.sendKeys(Keys.ENTER);
		hardwait(3000);
		String emails=tmails.get(3).getText();
		System.out.println("Total no emails "+emails);
		
	}

	
}
