package com.hubspot.base;


import java.awt.Choice;
import java.beans.FeatureDescriptor;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	
	public WebDriver driver;
	public Properties prop;
	public static String flash;
	
	
	
	public WebDriver initialize_driver(Properties prop){
		
		
	//	String browser="chrome";
		
		String browser=prop.getProperty("browser");
		String headless=prop.getProperty("headless");	 // headless
		flash=prop.getProperty("elementflash");
		
		if(browser.equalsIgnoreCase("chrome")){
			//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "/Users/uasc/Desktop/chromedriver");

		if (headless.equalsIgnoreCase("no")) {
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}else{
		driver=new ChromeDriver();
		}
	}

	else if(browser.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		if (headless.equals("yes")) {
			FirefoxOptions fo=new FirefoxOptions();
			fo.addArguments("--headless");
			driver=new FirefoxDriver(fo);
		}else{
				driver=new FirefoxDriver();
			}
			
		}
	
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	
		driver.get(prop.getProperty("url"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}	
		
		return driver;
		
	}
	
		public Properties initialize_properties(){
			
			prop = new Properties();
			try {
				FileInputStream ip=new FileInputStream("/Users/uasc/Documents/workspace/FebruaryTestNG_2020Halil/src/main/java/config/hubspot/config/config.properties");
				prop.load(ip);
			} catch (Exception e) {
				e.printStackTrace();
				
			
			}
			
			return prop;
			
			
		}
	
		
		public void quitBrowser(){
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("some exception occured while quitting browser");
				
				
			
			}
			
		}
		
		public void closeBrowser(){
			try {
				driver.close();
			} catch (Exception e) {
				System.out.println("some exception occured while closing browser");
			}
		}
	
	
	
}
