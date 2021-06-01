package com.eportal.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eportal.qa.base.TestBase;
import com.eportal.qa.pages.ContactsPage;
import com.eportal.qa.pages.CreateNewContact;
import com.eportal.qa.pages.HomePage;
import com.eportal.qa.pages.LoginPage;
import com.eportal.qa.util.TestUtil;

public class CreateNewContactTest extends TestBase {

	LoginPage loginpage ;
	HomePage  homepage ;
	ContactsPage contactspage;
	TestUtil testutil;
	CreateNewContact Createnewcntctpage;
	
	String sheetName = "contacts";
	
	public CreateNewContactTest() {
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
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getCRMTestData")
	public void createnewaccount(String fname,String lname,String middle,String email,String desc) {
		Createnewcntctpage= contactspage.createNewContactClick();
		
		//Createnewcntctpage.addnewcontact("ritu","gautam","paul","rt794@gmail.com","btech");
		
		Createnewcntctpage.addnewcontact(fname,lname,middle,email,desc);		
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
