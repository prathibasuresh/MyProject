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
import com.mystore.pages.AddressPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.pages.OrderConfirmationPage;
import com.mystore.pages.OrderPage;
import com.mystore.pages.OrederSummaryPage;
import com.mystore.pages.PaymentPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.pages.ShippingPage;
import com.mystore.utility.Log;

/**
 * @author Owner
 *
 */
public class EndToEndTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	SearchResultPage searchresultPage;
	AddToCartPage addTocartpage;
	OrderPage orderpage;
	AddressPage addresspage;
	ShippingPage shippinpage;
	PaymentPage paymentpage;
	OrederSummaryPage orderSummarypage;
	OrderConfirmationPage orderConfirmationpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) { 
	launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		driver.close();
	}
	
//	@Test(groups = "Regression")
//	public void endToendTest() throws Throwable {
//		indexpage = new IndexPage();
//		searchresultPage = indexpage.searchProduct("t-shirt");
//		addTocartpage = searchresultPage.clickOnProductResult(); 
//		addTocartpage.enterQuantity("2");
//		addTocartpage.selectSize("M");
//		addTocartpage.clickOnAddToCart();
//		addTocartpage.validateAddToCartSuccessfullMsg();
//		orderpage = addTocartpage.clickOnCheckOut();
//		loginpage = orderpage.clickOnCheckOut();
//		addresspage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
//		shippinpage = addresspage.clickOnCheckOut();
//		shippinpage.selectChechBox();
//		paymentpage = shippinpage.clcikOnCheckOut();
//	    orderSummarypage = paymentpage.clickOnPayBank();
//	    orderConfirmationpage = orderSummarypage.clickOnConfirmOrder();
//		String actualMsg = orderConfirmationpage.validateMyStorIsCompleted();
//		String expectedMsg = "Your order on My Store is complete.";
//		Assert.assertEquals(actualMsg,expectedMsg);
//		
//	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("endToEndTest");
		indexpage= new IndexPage();
		searchresultPage=indexpage.searchProduct(productName);
		addTocartpage=searchresultPage.clickOnProductResult();
		addTocartpage.enterQuantity(qty);
		addTocartpage.selectSize(size);
		addTocartpage.clickOnAddToCart();
		addTocartpage.validateAddToCartSuccessfullMsg();
		orderpage=addTocartpage.clickOnCheckOut();
		loginpage=orderpage.clickOnCheckOut();
		addresspage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"),addresspage);
		shippinpage=addresspage.clickOnCheckOut();
		shippinpage.selectChechBox();;
		paymentpage=shippinpage.clcikOnCheckOut();
		orderSummarypage = paymentpage.clickOnPayBank();
		orderConfirmationpage=orderSummarypage.clickOnConfirmOrder();
		String actualMessage=orderConfirmationpage.validateMyStorIsCompleted();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.endTestCase("endToEndTest");
	}

}
