package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class GoogleApp extends CommonMethods {
	

	static Logger log=(Logger) LogManager.getLogger(GoogleApp.class);

	@FindBy(id="gbwa")
	WebElement google_app;
	@FindBy(linkText="More from Google")
	WebElement moreFromGoogle;
    
	@FindBy(xpath="//li[@class='j1ei8c']")
	List<WebElement> app_list;
	
	public GoogleApp() {
		PageFactory.initElements(driver, this);
	}
	
	public void homepageAvailable(){
		Homepage homepage=new Homepage();
		homepage.checkHomepage();
	}
	
	public void googleAppCheck(){
		google_app.click();
		hardwait(2000);
		driver.switchTo().frame(1);
		getScreenshot("GoogleApp1");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.out.println("Size "+app_list.size());
		js.executeScript("arguments[0].scrollIntoView();", app_list.get(25));
		hardwait(3000);
	    getScreenshot("GoogleApp2");
		js.executeScript("arguments[0].scrollIntoView();", app_list.get(0));
		
		hardwait(2000);
		log.info("In Google Apps ");
	}
	
	
}
