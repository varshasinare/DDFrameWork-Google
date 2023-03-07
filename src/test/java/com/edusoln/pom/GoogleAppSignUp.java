package com.edusoln.pom;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class GoogleAppSignUp extends CommonMethods {
	
	@FindBy(id="gbwa")
	WebElement google_app;
	@FindBy(xpath="//li[@class='j1ei8c']")
	List<WebElement> app_list;
	
	@FindBy(xpath="//a[text()='Go to Google Account']")
	List<WebElement> google_account;
	@FindBy(id="identifierId")
	WebElement email;
	@FindBy(xpath="//span[@class='VfPpkd-vQzf8d']")
	List<WebElement> email_next;
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	@FindBy(xpath="//span[text()='Next']")
	WebElement pass_next;
	@FindBy(xpath="//a[@class='RlFDUe EhlvJf KKjvXb']")
	WebElement home;
	@FindBy(xpath="//h1[@class='XY0ASe']")
	WebElement name;
	
	Logger log=LogManager.getLogger(GoogleAppSignUp.class);
	
	public GoogleAppSignUp(){
		PageFactory.initElements(driver, this);
	}
	
	public void googleHomepage()
	{
		GoogleApp googleApp=new GoogleApp();
		googleApp.homepageAvailable();
	}
	
	public void app_Sign_Up(Map<Object,Object> data) {
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(1);
		hardwait(1000);
		app_list.get(0).click();
		hardwait(1000);
		google_account.get(1).click();
		hardwait(1000);
		email.sendKeys(data.get("EmailID").toString());  //vrshholkar
		email_next.get(1).click();
		hardwait(4000);
		password.sendKeys(data.get("Pass").toString());   //Varsha@123
		hardwait(2000);
		pass_next.click();
		waitForDisplay(home);
		log.info("logged successfully");
		System.out.println(name.getText());
		softassert.assertTrue(name.getText().contains(data.get("FirstName").toString()));
		
		
	}

}
