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
public class PaymentPage extends BaseClass {
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBank;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement payByCkeck;
	
	public PaymentPage() {
		PageFactory.initElements(driver,this);
	}
	
	public OrederSummaryPage clickOnPayBank() {
		Action.click(driver, payByBank);
		return new OrederSummaryPage();
		
	}
}
