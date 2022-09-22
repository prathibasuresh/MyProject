/**
 * 
 */
package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author Owner
 *
 */
public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath = "//strong[contains(text() ,'Your order on My Store is complete')]")
	WebElement confirmMsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validateMyStorIsCompleted() {
		String confirm = confirmMsg.getText();
		return confirm;
	}

}
