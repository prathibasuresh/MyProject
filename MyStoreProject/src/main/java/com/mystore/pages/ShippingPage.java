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
public class ShippingPage extends BaseClass {
	
	@FindBy(id = "cgv")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOut;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectChechBox() {
		Action.fluentWait(driver, checkbox, 50);
		Action.click(driver, checkbox);
	}
	
	public PaymentPage clcikOnCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new PaymentPage();
	}
}
