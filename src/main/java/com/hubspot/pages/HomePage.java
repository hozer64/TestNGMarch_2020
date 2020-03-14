package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class HomePage extends BasePage {

	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header=By.xpath("//h1[@class='private-page__title']");
	By accountName=By.xpath("//span[text()='Kisga llc']");

	By contactMainTab=By.id("nav-primary-contacts-branch");
	By contactChildTab=By.id("nav-secondary-contacts");
	
	
		// constructor 
	public HomePage (WebDriver driver){
		this.driver=driver;	
		elementUtil=new ElementUtil(driver);
		
	}
	
		public String getHomePageTitle(){
			return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
			
			//return driver.getTitle();
		}
	
	public String getHomePageHeader(){
		return elementUtil.doGetText(header);
		
		//return driver.findElement(header).getText();
		
	}
	
	public String verifyLoggedInAccountName(){
		
		
		return elementUtil.doGetText(accountName);
		//return driver.findElement(accountName).getText();
	}
	
		
	private void ClickOnContact(){
		elementUtil.doClick(contactMainTab);
		elementUtil.doClick(contactChildTab);
	}
	
	public ContactsPage gotoContactsPage(){
		ClickOnContact();
		return new ContactsPage(driver);
	}
		
		
	
}
