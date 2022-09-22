/**
 * 
 */
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

/**
 * @author Owner
 *
 */
public class HomePageTest extends BaseClass{
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage = new HomePage();

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) { 
	launchApp(browser);
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
	driver.close();
	}
	
//	@Test(groups = "Smoke")
//	public void verifyWishList() throws Throwable {
//		indexpage =  new IndexPage();
//		loginpage = new LoginPage();
//		homepage = new HomePage();
//		
//		loginpage = indexpage.clickOnsignIn();
//		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean result = homepage.validateMyWishlists();
//		Assert.assertTrue(result);
//	}
//	
//	@Test(groups = "Smoke")
//	public void verifyOrderHistory() throws Throwable {
//		indexpage =  new IndexPage();
//		loginpage = new LoginPage();
//		homepage = new HomePage();
//		
//		loginpage = indexpage.clickOnsignIn();
//		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean result = homepage.validateOredrHistory();
//		Assert.assertTrue(result);
//	}
	
	@Test(groups = "Smoke",dataProvider = "Credentials", dataProviderClass = DataProviders.class)
	public void wishListTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("wishListTest");
		indexpage= new IndexPage();
		loginpage=indexpage.clickOnsignIn();
		homepage=loginpage.login(uname,pswd,homepage);
		boolean result=homepage.validateMyWishlists();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "Credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexpage= new IndexPage();
		loginpage=indexpage.clickOnsignIn();
		homepage=loginpage.login(uname,pswd,homepage);
		boolean result=homepage.validateOredrHistory();
		Assert.assertTrue(false);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
	

}
