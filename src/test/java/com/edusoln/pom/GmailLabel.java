package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class GmailLabel extends CommonMethods{
	
	@FindBy(xpath="//span[text()='More']")
	List<WebElement> more;
	@FindBy(xpath="//a[text()='Create new label']")
	WebElement new_lable_link;
	@FindBy(xpath="//span[@class='Kj-JD-K7-K0']")
	WebElement new_lable;
	@FindBy(xpath="//input[@class='xx']")
	WebElement lable_name;
	@FindBy(xpath="//button[@class='J-at1-auR']")
	WebElement create_btn;
	@FindBy(xpath="//span[text()='Labels']")
	WebElement labels;
	
	Logger log=LogManager.getLogger(GmailLabel.class);
	
	public GmailLabel()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewLable()
	{
		waitForDisplay(more.get(0));
		more.get(0).click();
		hardwait(2000);
		new_lable_link.click();
		hardwait(4000);
		waitForDisplay(new_lable);
		lable_name.sendKeys("Testings");
		hardwait(2000);
		create_btn.click();
		hardwait(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", labels);
		hardwait(2000);
		log.info("New Label has been created");
	}
}

