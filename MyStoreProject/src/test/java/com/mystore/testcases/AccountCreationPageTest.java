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
import com.mystore.pages.AccountCreationPage;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.utility.Log;

/**
 * @author Owner
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
		public void setUp(String browser) { 
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.close();
	}
	
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		indexpage= new IndexPage();
		loginpage=indexpage.clickOnsignIn();
		accountCreationPage = loginpage.createNewAccount(email);
		boolean result=accountCreationPage.ValiateFormTitle();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
}
