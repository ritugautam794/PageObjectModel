package com.eportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eportal.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Respository of LOGIN Page
	
		@FindBy(xpath="//span[@class='user-display']")
		@CacheLookup
		WebElement nameLabel;
		
		@FindBy(xpath="//div[@class='header item']")
		@CacheLookup
		WebElement cogmentoLogo;
		
		@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
		@CacheLookup
		WebElement loginBtn;
		
		@FindBy(xpath="//i[@class='home icon']")
		@CacheLookup
		WebElement homeIconLink;
		
		@FindBy(xpath="//i[@class='users icon']")
		@CacheLookup
		WebElement contactsLink;
		
		
		//Initialization of page objects
		public HomePage() {
			
			PageFactory.initElements(driver,this);
		}
		
		public String getHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyUsernameDisplayed() {
			return nameLabel.isDisplayed();
		}
		
		public ContactsPage clickContactsPage() {
			homeIconLink.click();
			contactsLink.click();
			return new ContactsPage();
		}
		
		
		
		
		
		

}
