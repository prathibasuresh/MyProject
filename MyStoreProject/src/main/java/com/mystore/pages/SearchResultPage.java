/**
 * 
 */
package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Owner
 *
 */
public class SearchResultPage extends BaseClass {

	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateProductResult() {
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProductResult() {
		Action.click(driver, productResult);
		return  new AddToCartPage();
	}
}
