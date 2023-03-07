package com.edusoln.pom;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edusoln.base.CommonMethods;

public class GoogleProducts  extends CommonMethods{
	
	@FindBy(xpath="//div[@data-g-module_id='For all']")
	WebElement for_all;
	@FindBy(xpath="//div[@data-g-module_name='Product Tile']")
	List<WebElement> product_list;
	@FindBy(xpath="//p[text()='Google TV']")
    WebElement googleTV;
	@FindBy(xpath="//p[text()='YouTube VR']")
	WebElement youtubeVR;
	
	 Logger log=LogManager.getLogger(GoogleProducts.class);
	 
	public GoogleProducts()
	{
		PageFactory.initElements(driver, this);
	}
	public void productlist(Map<Object,Object> ProductName)
	{
		driver.navigate().to("https://about.google/intl/en/products/");
		System.out.println("size :"+product_list.size());
		for(int i=0;i<product_list.size();i++)
		{
			
			String s=product_list.get(i).getText();
			System.out.println(s);
			String pn=ProductName.get("PName").toString();
			if(pn.contains(s))
			{
			    softassert.assertTrue(pn.contains(s));
				break;
				
			}
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", for_all);
		hardwait(2000);
	    getScreenshot("GoogleProduct1");
	    
	    js.executeScript("arguments[0].scrollIntoView();", googleTV);
	    softassert.assertTrue(googleTV.isDisplayed());
		hardwait(2000);
	    getScreenshot("GoogleProduct2");
	    
		js.executeScript("arguments[0].scrollIntoView();", youtubeVR);
		hardwait(2000);
		getScreenshot("GoogleProduct3");
		log.info("Check ScreenShots");
		
		
	}
}
