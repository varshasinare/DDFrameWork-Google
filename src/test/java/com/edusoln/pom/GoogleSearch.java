package com.edusoln.pom;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.edusoln.base.CommonMethods;

public class GoogleSearch  extends CommonMethods{
	
	Logger log=LogManager.getLogger(GoogleSearch.class);
	@FindBy(xpath="//input[@class='gLFyf']")
	WebElement search_box;
	
	@FindBy(xpath="//div[@class='mkHrUc']//ul//li/descendant::div[@class='wM6W7d']")
	List<WebElement> search_list;
    @FindBy(xpath="//span[@class='yKMVIe']")
    WebElement search_Name;
    @FindBy(xpath="//*[@id=\"kp-wp-tab-overview\"]/descendant::a//h3")
    List<WebElement> search_wiki;
	
	 public GoogleSearch()
	 {
		PageFactory.initElements(driver, this);
	 }
	 public void search(Map<Object,Object> data)
	 {
		 waitForDisplay(search_box);
		 String s=data.get("Name").toString();
		 search_box.sendKeys(s);
		 for(int i=0;i<search_list.size();i++)
		 {
			if(search_list.get(i).getText().contains(s))
			{
				search_list.get(i).click();
				break;
			}
		 }
		
		 waitForDisplay(search_Name);
		 softassert.assertTrue(search_Name.getText().equalsIgnoreCase(s));
		 for(int i=0;i<search_wiki.size();i++)
		 {
			 System.out.println(search_wiki.get(i).getText());
			
		 }
		 hardwait(2000);
		 log.info("search is successful");
		
		 
	 }
}
