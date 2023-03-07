package com.edusoln.pom;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.edusoln.base.CommonMethods;

public class GmailLogin extends CommonMethods

{
	@FindBy(linkText="Sign in")
	List<WebElement> sign_in;
	@FindBy(xpath="//div[@class='Bym39d']")
	WebElement google_logo;
	@FindBy(id="identifierId")
	WebElement email;
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	@FindBy(xpath="//input[@name='Passwd']")
	WebElement pwd;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement chechbox;
	@FindBy(xpath="//span[text()='Next']")
	WebElement pwd_next;
	@FindBy(xpath="//a[@aria-label='Gmail']//img")
	WebElement image;
	@FindBy(xpath="//img[@class='gb_h gbii']")
	WebElement gmail_logo;
	@FindBy(xpath="//div[@class='T-I T-I-KE L3']")
	WebElement compose;
	@FindBy(xpath="//div[@class='TN bzz aHS-bnt']")
	WebElement inbox;
	@FindBy(xpath="//div[@class='TN bzz aHS-bnw']")
	WebElement starred;
	@FindBy(xpath="//div[@class='TN bzz aHS-bu1']")
	WebElement snoozed;
	@FindBy(xpath="//div[@class='TN bzz aHS-bnu']")
	WebElement sent;
	@FindBy(xpath="//div[@class='TN bzz aHS-bnq']")
	WebElement  drafts;
	
	 Logger log=LogManager.getLogger(GmailLogin.class);
	 
	public GmailLogin()
	{
		PageFactory.initElements(driver, this);
	}
	public void login(Map<Object,Object> data)
	{
		
		driver.navigate().to(data.get("Gmail_url").toString());
		waitForDisplay(sign_in.get(0));
		sign_in.get(0).click();
		waitForDisplay(google_logo);
		email.sendKeys(data.get("EmailID").toString());
		hardwait(2000);
		next.click();
		log.info("Entered Valid EmailId");
		waitForDisplay(pwd);
		pwd.sendKeys(data.get("Pass").toString());
		chechbox.click();
		hardwait(2000);
		pwd_next.click();
		log.info("Entered Valid Password");
		hardwait(2000);
		log.info(" Gmail Logged in successfully");
		softassert.assertTrue(image.isDisplayed());
		softassert.assertTrue(gmail_logo.isDisplayed());
		softassert.assertTrue(compose.isDisplayed());
		softassert.assertTrue(inbox.isDisplayed());
		softassert.assertTrue(starred.isDisplayed());
		softassert.assertTrue(snoozed.isDisplayed());
		softassert.assertTrue(sent.isDisplayed());
		softassert.assertTrue(drafts.isDisplayed());
		
		
		
	}

}

