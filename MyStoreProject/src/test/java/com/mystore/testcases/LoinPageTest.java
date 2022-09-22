package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.utility.Log;

public class LoinPageTest extends BaseClass{

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	 @Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) { 
	launchApp(browser);
    }
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.close();
	}

	@Test(dataProvider = "Credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("Login");
		indexpage =  new IndexPage();
//		loginpage = new LoginPage();
//		homepage = new HomePage();
		Log.info("User is going to click on SignIn Option");
		loginpage = indexpage.clickOnsignIn();
		Log.info("Enter username and password");
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = loginpage.login(uname, pswd, homepage);
		String actualURL = homepage.getCurrentUrl();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verify that if user is able to login");
		Assert.assertEquals(actualURL,expectedURL);
		Log.info("login is success");
		Log.endTestCase("Login");
	}
	
	
	
	

}
