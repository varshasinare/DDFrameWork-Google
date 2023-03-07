package com.edusoln.runner;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.edusoln.base.CommonMethods;
import com.edusoln.base.Constants;
import com.edusoln.pom.ComposeEmail;
import com.edusoln.pom.GmailLabel;
import com.edusoln.pom.GmailLogin;
import com.edusoln.pom.GoogleApp;
import com.edusoln.pom.GoogleAppSignUp;
import com.edusoln.pom.GoogleAppVerify;
import com.edusoln.pom.GoogleProducts;
import com.edusoln.pom.GoogleSearch;
import com.edusoln.pom.Homepage;
import com.edusoln.pom.LanguageCheck;
import com.edusoln.pom.MailsWithAttachments;
import com.edusoln.pom.MoveToFolder;
import com.edusoln.pom.StarredEmail;
import com.edusoln.pom.TotalEmails;
import com.edusoln.pom.ReadEmail;
import com.edusoln.pom.ReceivedMails;
import com.edusoln.pom.SendEmail;
import com.edusoln.pom.Settings;
import com.edusoln.pom.SignOut;
import com.edusoln.utilities.ExcelReader;
import com.edusoln.utilities.PropertyReader;

public class TestNGRunner extends CommonMethods {
	
	Homepage homepage;
	GoogleApp googleApp;
	GoogleAppVerify apps;
	GoogleAppSignUp googleAppSignUp;
	LanguageCheck lang_check;
	GoogleSearch googleSearch;
	GoogleProducts googleProduct;
	GmailLogin gmailLogin;
	TotalEmails totalEmails;
	StarredEmail starredEmails;
	ReadEmail  readEmail;
	ComposeEmail composeEmail;
	SendEmail sendEmail;
	ReceivedMails receivedMails;
	MailsWithAttachments mailsWithAttachments;
	Settings settings;
	GmailLabel gmailLabel;
	SignOut signOut;
	MoveToFolder moveToFolder;
	
    Logger log=LogManager.getLogger(TestNGRunner.class);
    ExtentSparkReporter htmlreport;
    ExtentReports report;
   // ExtentTest test;
    
    
    @BeforeTest
    public void beforeTest()
    {
    	htmlreport=new ExtentSparkReporter(homepath+"\\src\\test\\resources\\Reports\\ExtentReport.html");
    	htmlreport.config().setDocumentTitle("Execution Report");
    	htmlreport.config().setTheme(Theme.DARK);
    	report=new ExtentReports();
    	report.attachReporter(htmlreport);
    }
    
    
	@BeforeMethod
	public void browserSetUp() {
		browserLauch(PropertyReader.getPropValue(Constants.BROWSER));
		driver.get(PropertyReader.getPropValue(Constants.URL));
		log.debug(PropertyReader.getPropValue(Constants.BROWSER)+" is launched Successfully");
		
	}

	@Test(priority=0,enabled=true)
	public void test() {
		log.info("In testcase 1, Display Google HomePage");
		test=report.createTest("Google Home Page");
		softassert=new SoftAssert();
		homepage=new Homepage();
		homepage.checkHomepage();
		test.log(Status.PASS, "Google Home Page displayed Successfully");
		softassert.assertAll();
	}
	
	@Test(priority=1,enabled=true)
	public void test2()
	{
		log.info("In testcase 2, Perform Click on Google App");
		test=report.createTest("Google App");
		softassert=new SoftAssert();
		googleApp=new GoogleApp();
		googleApp.homepageAvailable();
		googleApp.googleAppCheck();
		test.log(Status.PASS, "Google Apps displayed Successfully");
		softassert.assertAll();
	}
	/*Verify all apps are present */
	@Test(priority=2,enabled=true)
	public void test3()
	{
		log.info("In testcase 3, Verify Google Apps");
		test=report.createTest("Google App Verify");
		softassert=new SoftAssert();
		apps=new GoogleAppVerify();
		apps.googleHomepage();
		apps.appVerify();
		test.log(Status.PASS, "Google Apps verified Successfully");
		softassert.assertAll();
	}
	
	
	/*Sign in to apps*/
	
	@DataProvider(name="dp")
	public Object[][] dataSupplier()
	{
		Object finaldata[][]=ExcelReader.readExcel("Data");
		return finaldata;
	}
	
	@Test(dataProvider="dp",priority=3)
	public void test4( Map<Object,Object> data)
	{
		log.info("In testcase 4, Verify Google App SignUp ");
		test=report.createTest("Google App sign Up");
		softassert=new SoftAssert();
		googleAppSignUp=new GoogleAppSignUp();
		googleAppSignUp.googleHomepage();
		googleAppSignUp.app_Sign_Up(data);
		test.log(Status.PASS, "All google Apps are logged in Successfully");
		softassert.assertAll();
	}
	
	/*language Test*/
	@Test(priority=4)
	public void test5()
	{
		log.info("In testcase 5, Change Google lang");
		test=report.createTest("Google language Check");
		softassert=new SoftAssert();
		homepage=new Homepage();
		homepage.checkHomepage();
		lang_check=new LanguageCheck();
		lang_check.languageSet();
		test.log(Status.PASS, "On Google Home Page language displayed");
		softassert.assertAll();
		
	}
	
	/* Open and close Browser */
	@Test(priority=5)
	public void test6()
	{
		log.info("In testcase 6,Google browser open and close ");
		test=report.createTest("Browser Open and Close");
		softassert=new SoftAssert();
		homepage=new Homepage();
		homepage.checkHomepage();
		test.log(Status.PASS, "Google browser opened and closed Successfully");
		softassert.assertAll();
	}
	

	/* Search  */
	@DataProvider(name="dp1")
	public Object[][]dataSupplier1()
	{
		Object finaldata[][]=ExcelReader.readExcel("SearchData");
	    return finaldata;
	}
	@Test(dataProvider="dp1",priority=6)
	public void test7( Map<Object,Object> data)
	{
		log.info("In testcase 7, Google search");
		test=report.createTest("Google search verify");
		softassert=new SoftAssert();
		homepage=new Homepage();
		homepage.checkHomepage();
		googleSearch=new GoogleSearch();
		googleSearch.search(data);
		test.log(Status.PASS, "Search performed Successfully");
		softassert.assertAll();
	}
	
	@DataProvider(name="dp2")
	public Object[][] dataProvider()
	{
		Object[][] finalData=ExcelReader.readExcel("Product_List");
		return finalData;
	}
	
	@Test(dataProvider="dp2",priority=7)
	public void test8(Map<Object,Object> data)
	{
		log.info("In testcase 8,Verify All google product");
		test=report.createTest("Google Product");
		softassert=new SoftAssert();
		homepage=new Homepage();
		homepage.checkHomepage();
		googleProduct= new GoogleProducts();
		googleProduct.productlist(data);
		test.log(Status.PASS, "Google product displayed Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=8)
	public void test9(Map<Object,Object> data)
	{
		log.info("In testcase 9, Verify Gmail login");
		test=report.createTest("Login to Gmail");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		test.log(Status.PASS, "Logged to Gmail Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=9)
	public void test10(Map<Object,Object> data)
	{
		log.info("In testcase 10, Display total read Emails");
		test=report.createTest("Find total read Emails");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		totalEmails=new TotalEmails();
		totalEmails.getTotalEmails();
		test.log(Status.PASS, "Total read Emails displayed Successfully");
		softassert.assertAll();
	}

	@Test(dataProvider="dp",priority=10)
	public void test11(Map<Object,Object> data)
	{
		log.info("In testcase 11,Display total starred Emails");
		test=report.createTest("Find total Starred Emails");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		starredEmails=new StarredEmail();
		starredEmails.getStarredEmail();
		test.log(Status.PASS, "Total Starred Emails displayed Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=11)
	public void test12(Map<Object,Object> data)
	{
		log.info("In testcase 12, Display total Unread and Read Emails");
		test=report.createTest("Find total Unread Emails");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		readEmail=new ReadEmail();
		readEmail.getUnReadEmails();
		//ReadEmail.getReadEmails();
		test.log(Status.PASS, "Total Unread and Read Emails displayed Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=12)
	public void test13(Map<Object,Object> data)
	{
		log.info("In testcase 13, Compose Email");
		test=report.createTest("Compose Email");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		composeEmail=new ComposeEmail();
		composeEmail.writeEmail();		
		test.log(Status.PASS, "Email is composed Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=13)
	public void test14(Map<Object,Object> data)
	{
		log.info("In testcase 14, Send Email successfully");
		test=report.createTest("Send Emails");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		sendEmail=new SendEmail();
		sendEmail.testtoccbcc();		
		test.log(Status.PASS, " Emails is sent Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=14)
	public void test15(Map<Object,Object> data)
	{
		log.info("In testcase 15, Check received Emails");
		test=report.createTest("Find total Received Emails");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		receivedMails=new ReceivedMails();
		receivedMails.checkReceivedMail();		
		test.log(Status.PASS, "Checked received emails Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=15)
	public void test16(Map<Object,Object> data)
	{
		log.info("In testcase 16 , Find Emails with Attachments");
		test=report.createTest("Find total Emails with Attachments");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		mailsWithAttachments=new MailsWithAttachments();
		mailsWithAttachments.checkAttachment();		
		test.log(Status.PASS, "Emails with attachment found Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=16)
	public void test17(Map<Object,Object> data)
	{
		log.info("In testcase 17, Verify Setting Option");
		test=report.createTest("Verify setting option in Gmail");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
        settings=new Settings();
        settings.checkSettings();	
        test.log(Status.PASS, "Setting option verified Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=17)
	public void test18(Map<Object,Object> data)
	{
		log.info("In testcase 18");
		test=report.createTest("Create new Label Gmail ");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		gmailLabel=new GmailLabel();
		gmailLabel.createNewLable();	
		test.log(Status.PASS, "New Labels created Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=18)
	public void test19(Map<Object,Object> data)
	{
		log.info("In testcase 19 ,Move Email to Folder");
		test=report.createTest("Move emails to Folder");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		moveToFolder=new MoveToFolder();
		moveToFolder.moveToLable();	
		test.log(Status.FAIL, "Email moved to folder Successfully");
		softassert.assertAll();
	}
	
	@Test(dataProvider="dp",priority=19)
	public void test20(Map<Object,Object> data)
	{
		log.info("In testcase 20, Verify Gmail Logout");
		test=report.createTest("Sign out");
		softassert=new SoftAssert();
		gmailLogin=new GmailLogin();
		gmailLogin.login(data);
		signOut=new SignOut();
		signOut.logOut();	
		test.log(Status.PASS, "Gmail SignOut Successfully");
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
	@AfterTest
	public void afterTest()
	{
		report.flush();
		
	}


}
