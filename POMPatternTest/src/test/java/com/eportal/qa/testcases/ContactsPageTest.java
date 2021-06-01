package com.eportal.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eportal.qa.base.TestBase;
import com.eportal.qa.pages.ContactsPage;
import com.eportal.qa.pages.HomePage;
import com.eportal.qa.pages.LoginPage;
import com.eportal.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage ;
	HomePage  homepage ;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initilization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		contactspage = homepage.clickContactsPage();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='header item']"))).build().perform();
		System.out.println("before method");
		
	}
	
	@Test(priority=1)
	public void ValidateContactsPageTitleTest() {
		String title = contactspage.getContactPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test(priority=2)
	public void ValidateifContactsLabelpresent() {
		boolean b = contactspage.getContactsLabel();
		Assert.assertTrue(b);
		
	}
	
	@Test(priority=3)
	public void validateclickoncontactstable() {
		contactspage.selectContactsByName("ritu paul");
		
	}
	
	@Test(priority=3)
	public void ValidateClickOnCreatNewcontact() {
		contactspage.createNewContactClick();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	

}
