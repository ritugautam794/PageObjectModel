package com.eportal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eportal.qa.base.TestBase;
import com.eportal.qa.pages.ContactsPage;
import com.eportal.qa.pages.HomePage;
import com.eportal.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage ;
	HomePage  homepage ;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	//testcases hould be seperated with each other
	//Before each testcase - launch fresh browser and do login
	//testcase-- execute all the steps from start to end
	//after the testcase -- close the brower and quit
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void ValidateHomePageTitleTest() {
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test(priority=2)
	public void ValidateUserNameLabel(){
		boolean b = homepage.verifyUsernameDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void ValidateContactsClick(){
		contactspage= homepage.clickContactsPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
