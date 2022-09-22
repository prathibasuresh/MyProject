package com.mystore.pages;

import  org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy (id = "email")
	WebElement userName;
	
	@FindBy(id = "passwd")
	WebElement passWord;
	
	@FindBy(id = "SubmitLogin")
	WebElement SignInButton;
	
	@FindBy( id = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy (name = "SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(passWord, pswd);
		Action.JSClick(driver, SignInButton);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
	
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(passWord, pswd);
		Action.click(driver, SignInButton);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}

} 
