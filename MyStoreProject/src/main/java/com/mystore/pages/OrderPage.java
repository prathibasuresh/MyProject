package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath = " //td[@class='cart_unit']//span//span[@class='price']")
	WebElement unitPrice;
	
	@FindBy(xpath = " //td[@id='total_price_container']//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath = " //span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(driver,this);
	}

	public double getUnitPrice() {
		Action.fluentWait(driver, unitPrice, 50);
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double finalTotalPrice = Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.click(driver, proceedToCheckOut);
		return new LoginPage();
	}
}
