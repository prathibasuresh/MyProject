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
public class OrederSummaryPage extends BaseClass{

	@FindBy(xpath = "//span[contains(text() ,'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	
	public OrederSummaryPage() {
		PageFactory.initElements(driver,this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrder() {
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
