package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.edusoln.base.CommonMethods;

public class Homepage  extends CommonMethods{
	
	 Logger log=LogManager.getLogger(Homepage.class);
	
	@FindBy(xpath="//*[@id=\"logo\"]]")
	WebElement google_logo;
	@FindBy (xpath="//a[contains(.,'Sign in')]")
	WebElement sign_in;
	@FindBy(xpath = "//input[@class='gLFyf']")
	WebElement txt_box;
	@FindBy(xpath="//input[@class='gNO89b']")
	List<WebElement>google_Search_btn;
	@FindBy(xpath="//input[@class='RNmpXc']")
	List<WebElement>lucky_btn;
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	public void checkHomepage()
	{
		hardwait(2000);
		//waitForDisplay(google_logo);						//Google logo
		getScreenshot("HomepageImage");
		softassert.assertTrue(sign_in.isDisplayed());			//Sign in
		String title=driver.getTitle();						//page Title
		System.out.println("Page Title: "+title);
		softassert.assertTrue(title.equalsIgnoreCase("Google"));
		softassert.assertTrue(google_Search_btn.get(1).isDisplayed());   //Google Search 
		softassert.assertTrue(lucky_btn.get(1).isDisplayed());         //I'am feeling lucky
		log.info("HomePage is Displayed properly");
		
		
		
	}

}
