package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class MoveToFolder extends CommonMethods {

	@FindBy(xpath = "//a[text()='Inbox']")
	WebElement Inbox;

	@FindBy(xpath = "//span[@class='Dj']//span/descendant::span[@class='ts']")
	List<WebElement> tmails; // get 3rd element

	@FindBy(xpath = "//div[@class='ae4 aDM nH oy8Mbf']//td[@data-tooltip='Select']//div[@role='checkbox']")
	List<WebElement> select;
	@FindBy(xpath = "//div[@class='ae4 aDM nH oy8Mbf']//div[@class='yW']//span[1]//span")
	List<WebElement> InboxAllMail;
	//@FindBy(xpath = "//div[@class='aeH']/div/descendant::div[@aria-label='Move to']")
	//WebElement MoveToBtn;
	@FindBy(xpath = "//input[@aria-label='Move-to menu open']")
	WebElement MovetToBox;
	@FindBy(xpath = "//*[@class='J-M-Jz aiL']//div//div[@class='J-N-Jz']//b")
	WebElement MoveToLabelSelect;
	@FindBy(xpath = "//*[@class='ae4 UI nH oy8Mbf']//div[@class='yW']//span[1]//span")
	WebElement MovedToLabelMail;
	@FindBy(xpath = "//*[@class='TO']//div//div[3]//span//a")
	List<WebElement> Label;

	Logger log=LogManager.getLogger(MoveToFolder.class);
	public MoveToFolder() {
		PageFactory.initElements(driver, this);
	}

	public void moveToLable()
	{
		Inbox.click();
		 hardwait(2000);
		 select.get(0).click();
		 select.get(1).click();
		
		hardwait(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//WebElement MoveToBtn= driver.findElement(By.xpath("//div[@class='aeH']/div/descendant::div[@aria-label='Move to']"));
		hardwait(2000);
		//js.executeScript("arguments[0].click();",MoveToBtn);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[@id=\":1z\"]/div[1]")));
		hardwait(2000);
		
		//WebElement MoveToBtn= driver.findElement(By.xpath("//div[@class='aeH']/div/descendant::div[@aria-label='Move to']"));
		//hardwait(2000);
		//MoveToBtn.click();
		//hardwait(2000);
		
		//log.debug("Email move to folder failed");
		//waitForDisplay(MovetToBox);
		//MovetToBox.sendKeys("Testing");
		//waitForDisplay(MoveToLabelSelect);
		//MoveToLabelSelect.click();
		
		
	}
}
