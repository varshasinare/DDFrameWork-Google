package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class SendEmail extends CommonMethods {
	
	@FindBy(xpath="//div[@class='T-I T-I-KE L3']")
	WebElement compose;
	@FindBy(xpath="//input[@class='agP aFw']")
	WebElement to;
	@FindBy(xpath="//input[@class='yNVtPc ZAGvjd Ny5lGc']")
	WebElement search;
	@FindBy(xpath="//span[text()='All contacts']")
	WebElement allContact;
	@FindBy(xpath="//div[@class='azC3yf']")
	WebElement email;
	@FindBy(xpath="//span[@class='VfPpkd-vQzf8d']")
	WebElement insert;
	
	@FindBy(xpath="//div[@name='cc']//div//input")
	WebElement cc;
	@FindBy(xpath="//span[text()='Cc'][contains(@data-tooltip,'Cc')]")
	WebElement cc_btn;
	
	@FindBy(xpath="//span[text()='Bcc'][contains(@data-tooltip,'Bcc')]")
	WebElement Bcc_btn;
	@FindBy(xpath="//div[@name='bcc']//div//input")
	WebElement bcc;
	
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subject;
	@FindBy(xpath="//div[@class='Am Al editable LW-avf tS-tW']")
	WebElement mailBody;
	@FindBy(xpath="//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
	WebElement send;
	
	Logger log=LogManager.getLogger(SendEmail.class);
	public SendEmail(){
		
		PageFactory.initElements(driver, this);
	}
	public void testtoccbcc()
	{
		compose.click();
		hardwait(2000);
		to.click();
		to.sendKeys("varshah.holkar@gmail.com");
		log.info("Added to");
		cc_btn.click();
		hardwait(2000);
		cc.sendKeys("sinare21@gmail.com");
		log.info("Added cc");
		Bcc_btn.click();
		hardwait(2000);
		bcc.sendKeys("sinare21@gmail.com");
		log.info("Added bcc");
	
		//subject.click();
		subject.sendKeys("Test Mail");
		hardwait(2000);
		mailBody.click();
		hardwait(2000);
		mailBody.sendKeys("Hi");
		hardwait(2000);
		
		send.click();
		log.info("Email Sent");
	}
}
