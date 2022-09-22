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
import com.mystore.pages.IndexPage;
import com.mystore.utility.Log;

/**
 * @author Owner
 *
 */
public class IndexPageTest extends BaseClass{
	
	IndexPage indexpage =  new IndexPage();
	
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
//	public void VerifyLogo() {
//		
//		boolean result = indexpage.validateMyStoreogo();
//		Assert.assertFalse(result);	
//	}
//	
//	@Test(groups = "Smoke")
//	public void validateTitle() {
//		String title = indexpage.verifyTitle();
//		Assert.assertEquals(title,"My Store");
//		}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexpage= new IndexPage();
		boolean result=indexpage.validateMyStoreogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle=indexpage.verifyTitle();
		Assert.assertEquals(actTitle, "My Store1");
		Log.endTestCase("verifyTitle");
	}
	
	
 
}
