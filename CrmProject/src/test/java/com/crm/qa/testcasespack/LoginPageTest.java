package com.crm.qa.testcasespack;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.basepack.BaseClass;
import com.crm.qa.pagespack.HomePage;
import com.crm.qa.pagespack.LoginPage;


@Listeners(com.crm.qa.utilpack.TestCommonUtiles.class)
public class LoginPageTest extends BaseClass {
	public LoginPage lp;
	public HomePage hp;
	
//	public LoginPageTest() {
//		super();
//		
//	}
//	
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		lp=PageFactory.initElements(driver, LoginPage.class);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	 
	@Test(priority=1)
	public void validateTitle() {
		String title= lp.loginPageTitle();
		Assert.assertEquals(title, "firsttrial CRM");
	}
	@Test(priority=2)
	public void validateLoginLogo() {
		boolean flag =lp.loginLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void validateRememberUserName() {
		boolean flag= lp.rememberUserName();
		Assert.assertFalse(flag);
	}
	@Test(priority=4)
	public void validateLogin() {
		 hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
		//Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
