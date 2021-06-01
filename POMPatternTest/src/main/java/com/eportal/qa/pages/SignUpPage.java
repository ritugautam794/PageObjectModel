package com.eportal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eportal.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(xpath="//a[@title='register on freecrm.com']")
	WebElement SignUpBtn;

}
