package com.eportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eportal.qa.base.TestBase;

public class CreateNewContact extends TestBase {
	
	@FindBy(xpath="//div[text()='Create New Contact']")
	WebElement createNewContactLabel;
	
	@FindBy(name="first_name")
	WebElement first_name;
	
	@FindBy(name="last_name")
	WebElement last_name;
	
	@FindBy(name="middle_name")
	WebElement middle_name;
	
	@FindBy(name="value")
	WebElement email1;
	
	@FindBy(name="description")
	WebElement description;
	
	@FindBy(xpath="//button[@class='ui linkedin button' and text()='Save' ]")
	WebElement saveBtn;
	
	public CreateNewContact() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean CheckifCreateNewContactPresent() {
		return createNewContactLabel.isDisplayed();
	}
	
	public void addnewcontact(String fname,String lname,String middle,String email,String desc) {
		
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		middle_name.sendKeys(middle);
		email1.sendKeys(email);
		description.sendKeys(desc);
		saveBtn.click();
	}

}
