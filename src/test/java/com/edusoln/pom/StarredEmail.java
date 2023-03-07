package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class StarredEmail extends CommonMethods{

	@FindBy(xpath="//div[@class='aio UKr6le']")
	List<WebElement> email_options;
	
	@FindBy(xpath="//span[@class='Dj']//span/descendant::span[@class='ts']")
	List<WebElement> tmails;  //get 3rd element 
	
	Logger log=LogManager.getLogger(StarredEmail.class);
	public StarredEmail()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getStarredEmail()
	{
		email_options.get(1).click();
		hardwait(2000);
		String emails=tmails.get(3).getText();
		log.info("Starred Emails");
		System.out.println("Total no emails "+emails);
		
		
	}
	
}
