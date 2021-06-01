package com.eportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eportal.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Respository of LOGIN Page
	
	@FindBy(name="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pass;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgotPassLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	//Initialization of page objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Functions of the login page -methods	
	public String checkLoginPageTitle() {
		
		return driver.getTitle();	
	}
	
	public boolean checkForgetPasswordLink() {
		return ForgotPassLink.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd) {
		email.sendKeys(un);
		pass.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	

}
