package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;
import com.edusoln.runner.TestNGRunner;

public class LanguageCheck extends CommonMethods{
	
	@FindBy(xpath="//div[text()='Settings']")
	WebElement setting;
	@FindBy(linkText="Search settings")
	WebElement search_set;
	@FindBy(xpath="//a[text()='Languages']")
	WebElement lang;
	@FindBy(id="langanchormore")
	WebElement Show_more;
	@FindBy(xpath="//span[text()='हिन्दी']")
	List<WebElement> hindi;
	@FindBy(xpath="//div[text()='Save']")
	WebElement save;
	
	Logger log=LogManager.getLogger(LanguageCheck.class);

	public LanguageCheck()
	{
		PageFactory.initElements(driver, this);
	}
	public void languageSet()
	{
		waitForDisplay(setting);
		setting.click();
		search_set.click();
		lang.click();
		Show_more.click();
		
		hindi.get(0).click();
		hardwait(2000);
		save.click();
		hardwait(3000);
		Alert alert=driver.switchTo().alert();
		driver.switchTo().alert().accept();
		hardwait(2000);
		
		
		//driver.navigate().refresh();
		driver.navigate().back();
		hardwait(5000);
		log.info("Language is set successfully");
		
	}
	
}
