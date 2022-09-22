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
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author Owner
 *
 */
public class AddToCartPageTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultPage;
	AddToCartPage addTocartpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) { 
	launchApp(browser);
}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.close();
	}
		
	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("addToCartTest");
		indexpage= new IndexPage();
		searchresultPage=indexpage.searchProduct(productName);
		addTocartpage=searchresultPage.clickOnProductResult();
		addTocartpage.enterQuantity(qty);
		addTocartpage.selectSize(size);
		addTocartpage.clickOnAddToCart();
		boolean result=addTocartpage.validateAddToCartSuccessfullMsg();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}
}
