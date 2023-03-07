package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class ReadEmail extends CommonMethods{
	
	@FindBy(xpath="//input[@aria-label='Search mail']")
	WebElement search_mail;
	
	@FindBy(xpath="//span[@class='Dj']//span/descendant::span[@class='ts']")
	List<WebElement> tmails;  //get 3rd element 
	
	 Logger log=LogManager.getLogger(ReadEmail.class);
	public ReadEmail()
	{
		PageFactory.initElements(driver, this);
	}
	
    public void getUnReadEmails()
    {
    	search_mail.click();
    	search_mail.sendKeys("label:unread");
    	search_mail.sendKeys(Keys.ENTER);
		hardwait(2000);
		String emails=tmails.get(3).getText();
		System.out.println("Total no UnRead emails "+emails);
		hardwait(2000);
    }
    
    public void getReadEmails()
    {
    	search_mail.click();
    	search_mail.clear();
    	search_mail.sendKeys("label:read");
    	search_mail.sendKeys(Keys.ENTER);
		hardwait(2000);
		String emails=tmails.get(3).getText();
		System.out.println("Total no Read emails "+emails);
    }
}
