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
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author Owner
 *
 */
public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultPage;

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
//	public void productSearchTest() throws Throwable {
//		indexpage = new IndexPage();
//		searchresultPage = indexpage.searchProduct("t-shirt");
//		boolean result = searchresultPage.validateProductResult();
//		Assert.assertTrue(result);
//	}

	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		indexpage= new IndexPage();
		searchresultPage=indexpage.searchProduct(productName);
		boolean result=searchresultPage.validateProductResult();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

	
}
