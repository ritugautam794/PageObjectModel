package com.eportal.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eportal.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	//xpth--->//div[@class='ui loader']
	//xpath-->//div[contains(text(),'Contacts')]
	
	@FindBy(xpath="//div[@class='ui loader']//parent::div[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[@class='ui linkedin button' and text()='Create']")
	WebElement createNewcontact;
	

////a[contains(text(),'ritu paul')]//parent::td//parent::tr//td//div[@class='ui fitted read-only checkbox']//input[@name='id']
	
	public ContactsPage() {
		
		PageFactory.initElements(driver,this);
	}
	public String getContactPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//parent::tr//td//div[@class='ui fitted read-only checkbox']//input[@name='id']")).click();
	}
	
	public CreateNewContact createNewContactClick() {
		
		createNewcontact.click();
		return new CreateNewContact();
		
	}
	
	
	
	

}
