package com.eportal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eportal.qa.base.TestBase;
import com.eportal.qa.pages.HomePage;
import com.eportal.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage ;
	HomePage  homepage ;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void ValidateTitle() {
		String title = loginpage.checkLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test(priority=2)
	public void ValidateForgotPasswordLink() {
		boolean b = loginpage.checkForgetPasswordLink();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void ValidateLoginFunctionality() {
		homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
