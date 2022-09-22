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
public class AddressPage extends BaseClass {

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement checkOutBtn;
	
	public AddressPage() {
		PageFactory.initElements(driver,this);
	}
	
	public ShippingPage clickOnCheckOut() {
		Action.click(driver, checkOutBtn);
		return new ShippingPage();
	}
}
