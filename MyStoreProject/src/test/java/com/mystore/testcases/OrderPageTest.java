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
import com.mystore.pages.OrderPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author Owner
 *
 */
public class OrderPageTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultPage;
	AddToCartPage addTocartpage;
	OrderPage orderpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) { 
	launchApp(browser);
	}
	
//	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
//	public void setUp() { 
//	launchApp();
//	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.close();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		indexpage= new IndexPage();
		searchresultPage=indexpage.searchProduct(productName);
		addTocartpage=searchresultPage.clickOnProductResult();
		addTocartpage.enterQuantity(qty);
		addTocartpage.selectSize(size);
		addTocartpage.clickOnAddToCart();
		addTocartpage.validateAddToCartSuccessfullMsg();
		orderpage=addTocartpage.clickOnCheckOut();
		Double unitPrice=orderpage.getUnitPrice();
		Double totalPrice=orderpage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}
}
