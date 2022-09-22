package com.mystore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchField;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchBtn;
	
	
	public IndexPage() {
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage clickOnsignIn() throws Throwable {
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateMyStoreogo() {
		Action.fluentWait(driver, myStoreLogo, 50);
		boolean flag = Action.isDisplayed(driver, myStoreLogo);
		System.out.println(flag);
		return flag;
	}
	
	public String verifyTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
		
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchField, productName);
		Action.click(driver, searchBtn);
		return new SearchResultPage();
	}
	
	

}
