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
public class AddToCartPage extends BaseClass{

	
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//i[@class= 'icon-ok']")
	WebElement addToCartSuccessfullMsg;
	
	@FindBy(xpath = " //span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	
	public AddToCartPage() {
		 PageFactory.initElements(driver,this);
	}
	
	public void enterQuantity(String qnty) {
		Action.type(quantity, qnty);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1,size);
	}
	
	public void clickOnAddToCart() {
		Action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddToCartSuccessfullMsg() {
		Action.fluentWait(driver, addToCartSuccessfullMsg, 50);
		return Action.isDisplayed(driver, addToCartSuccessfullMsg);
	}
	
	public OrderPage clickOnCheckOut() {
		Action.fluentWait(driver, addToCartBtn, 50);
		Action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
			
}
