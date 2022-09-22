package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mystore.actiondriver.Action;
import com.mystore.pages.IndexPage;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	// Declare ThreadLocal Driver
		// public static  ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
		
		@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
		public void loadConfig() {
			ExtentManager.setExtent();
			DOMConfigurator.configure("log4j.xml");
			
			try {
				prop = new Properties();
				System.out.println("super constructor is invoked");
				FileInputStream ip = new FileInputStream("D:\\Automation_Project\\MyStoreProject\\Configuration\\Config.properties");
				prop.load(ip);
				System.out.println("driver :"+driver);
				}
				catch(FileNotFoundException e )
				{ 
					e.printStackTrace();
				}
				catch(IOException e){
					e.printStackTrace();
				}
		}
		
//		public static WebDriver driver {
//			return driver.get();
//		}	 
	
//	 public static void launchApp() {
//			 String browserName = prop.getProperty("browser");
//			if (browserName.equalsIgnoreCase("Chrome")) {
//				//WebDriverManager.chromedriver().setup();
//				// Set Browser to ThreadLocalMap
//				//driver.set(new ChromeDriver());
//				driver = new ChromeDriver();
//			} else if (browserName.equalsIgnoreCase("FireFox")) {
//				//WebDriverManager.firefoxdriver().setup();
//				//driver.set(new FirefoxDriver());
//				
//				driver = new FirefoxDriver();
//			} else if (browserName.equalsIgnoreCase("IE")) {
//				//WebDriverManager.iedriver().setup();
//				//driver.set(new InternetExplorerDriver());
//				
//				driver = new InternetExplorerDriver();
//			}
//			//Maximize the screen
//			driver.manage().window().maximize();
//			//Delete all the cookies
//			driver.manage().deleteAllCookies();
//			//Implicit TimeOuts
//			driver.manage().timeouts().implicitlyWait
//			(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//			//PageLoad TimeOuts
//			driver.manage().timeouts().pageLoadTimeout
//			(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
//			//Launching the URL
//			driver.get(prop.getProperty("url"));
//		}
	 
	
	 public static void launchApp(String browserName) {
		 WebDriverManager.chromedriver().setup();
		 //String browserName = prop.getProperty("browser");
		 if(browserName.contains("Chrome")) {
			 driver = new ChromeDriver();
		 }
		 else if(browserName.contains("FireFox")) {
			 driver = new FirefoxDriver();
		 }else if(browserName.contains("IE")) {
			 driver = new InternetExplorerDriver();
		 }
		 
	//	Maximize the screen
			driver.manage().window().maximize();
	//Delete all the cookies
			driver.manage().deleteAllCookies();
	//Implicit TimeOuts
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//PageLoad TimeOuts
			driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	//Launching the URL
			driver.get(prop.getProperty("url"));
		 
	 }
	 
	 @AfterSuite
	 public void afterSuite() {
		 ExtentManager.endReport();
	 }

}
