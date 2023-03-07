package com.edusoln.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class GoogleAppVerify extends CommonMethods{

	static Logger log=LogManager.getLogger(GoogleAppVerify.class);
	
	@FindBy(id="gbwa")
	WebElement google_app;
	@FindBy(xpath="//ul[contains(@class, 'LVal7b')]")
	List<WebElement> frame_list;
	@FindBy(xpath="//li[@class='j1ei8c']")
	List<WebElement> app_list;
	
	@FindBy(className="h-c-header__product-logo-text")
	WebElement Account_header;
	
	@FindBy(xpath="//img[@class='lnXdpd']")
	WebElement google_image;
	@FindBy(xpath="//div[@class='SDkEP']")
	WebElement search_text;
	@FindBy(className="gNO89b")
	List<WebElement> google_Search_btn;
	@FindBy(className="RNmpXc")
	List<WebElement> lucky_btn;
	
	
	@FindBy(xpath="//*[@id='searchboxinput']")
	WebElement search_google_map;
	
	@FindBy(xpath="//yt-icon[@class='style-scope ytd-logo']")
	List<WebElement> youtube_logo;
	@FindBy(xpath="//input[@name='search_query']")
	WebElement youtube_search;
	
	@FindBy(xpath="//a[@class='f0UV3d']")
	WebElement google_play_logo;
	@FindBy(xpath="//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc']")
	WebElement google_play_search;
	
	@FindBy(id="sdgBod")
	WebElement google_News;
	@FindBy(xpath="//a[text()='Home']")
	WebElement News_Home;
	
	@FindBy(xpath="//span[@class='mobile-before-hero-only']")
	WebElement gmail_logo;
	@FindBy(xpath="//a[text()='Sign in']")
	WebElement gmail_sign_in;
	@FindBy(xpath="//span[text()='Create an account']")
	List<WebElement> create_account;
	
	@FindBy(xpath="//a[@class='glue-header__logo-link']")
	List<WebElement> drive_logo;
	@FindBy(xpath="//a[@class='glue-button glue-button--medium-emphasis']")
	WebElement go_to_drive;
	
	@FindBy(xpath="//span[text()='Translate']")
	List<WebElement> translate;
	
	@FindBy(xpath="//a[@class='header__logo']")
	List<WebElement> photo_logo;
	@FindBy(xpath="//a[text()=' Go to Google Photos ']")
	List<WebElement> googgle_photo;
	
	public GoogleAppVerify(){
		PageFactory.initElements(driver, this);
	}
	
	public void googleHomepage()
	{
		GoogleApp googleApp=new GoogleApp();
		googleApp.homepageAvailable();
	}
	
	public void appVerify() {
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(1);
		hardwait(1000);
		app_list.get(0).click();
		hardwait(2000);
		softassert.assertTrue(Account_header.isDisplayed());
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Google Account");
		
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(1).click();
		hardwait(2000);
		softassert.assertTrue(google_image.isDisplayed());
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Google Search");
		
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(2).click();
		hardwait(2000);
		softassert.assertTrue(search_google_map.isDisplayed());
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Google Map");
		

		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(3).click();
		hardwait(8000);
		waitForDisplay(youtube_logo.get(0));
		waitForDisplay(youtube_search);
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Google Youtube");
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(4).click();
		hardwait(2000);
		waitForDisplay(google_play_logo);
		waitForDisplay(google_play_search);
		//softassert.assertTrue(google_play_logo.isDisplayed());
		//softassert.assertTrue(google_play_search.isDisplayed());
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Google play");
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(5).click();
		hardwait(2000);
		waitForDisplay(google_News);
		waitForDisplay(News_Home);
		//softassert.assertTrue(google_News.isDisplayed());
		//softassert.assertTrue(News_Home.isDisplayed());
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Google News");
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(6).click();
		hardwait(2000);
		waitForDisplay(gmail_logo);
		waitForDisplay(gmail_sign_in);
		waitForDisplay(create_account.get(0));
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Gmail");
		
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(10).click();
		hardwait(2000);
		waitForDisplay(drive_logo.get(0));
		waitForDisplay(go_to_drive);
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Drive");
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(12).click();
		hardwait(2000);
		waitForDisplay(translate.get(1));
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Translate");
		
		google_app.click();
		hardwait(1000);
		driver.switchTo().frame(0);
		hardwait(1000);
		app_list.get(13).click();
		hardwait(2000);
		waitForDisplay(photo_logo.get(0));
		waitForDisplay(googgle_photo.get(0));
		driver.navigate().back();
		driver.navigate().refresh();
		hardwait(1000);
		log.info("On Photos");
		
	}
	
}
