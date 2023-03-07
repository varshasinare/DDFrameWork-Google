package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class MailsWithAttachments extends CommonMethods{
	
	@FindBy(xpath="//input[@aria-label='Search mail']")
	WebElement search_mail;
	
	@FindBy(xpath="//span[@class='Dj']//span/descendant::span[@class='ts']")
	List<WebElement> tmails;  //get 3rd element 
	
	Logger log=LogManager.getLogger(MailsWithAttachments.class);
	public MailsWithAttachments()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkAttachment()
	{
		search_mail.clear();
		search_mail.sendKeys("has:attachment");
		search_mail.sendKeys(Keys.ENTER);
		hardwait(2000);
		String emails=tmails.get(3).getText();
		System.out.println("Total no emails "+emails);
		log.info("Emails with attachments found");
	}

}
