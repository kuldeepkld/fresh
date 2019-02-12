package com.crm.qa.testcasespack;



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
public class HomePageTest extends BaseClass {
	public LoginPage lp;
	public HomePage hp;
	
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		lp=PageFactory.initElements(driver,LoginPage.class);
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
		hp= PageFactory.initElements(driver,HomePage.class);
	}
	
	@Test
	public void validatedashBoardButton() {
		hp.dashBoardButton();
		String title=driver.getTitle();
		Assert.assertEquals(title,"Dashboard | firsttrial CRM", "title of dashe boaed is not matched");	
	}
	
	@Test
	public void validatePeopleAndOrganisations() throws Throwable {
		hp.peopleAndOrganisations();
		Thread.sleep(2000);
		String title=driver.getTitle();
		Assert.assertEquals(title,"People & Organisations | firsttrial CRM");			
			
	}
	@Test
	public void validateCalendarAndTasks() throws Throwable {
		hp.clickCalendarAndTasks();
		Thread.sleep(2000);
		String title=driver.getTitle();
		Assert.assertEquals(title,"Calendar | firsttrial CRM");
	}
	
	@Test
	public void validateSalesPipeline() throws Throwable {
		hp.clickSalesPipeline();
		Thread.sleep(2000);
		String title=driver.getTitle();
		Assert.assertEquals(title,"Pipeline | firsttrial CRM");
	}
	
	@Test
	public void validateCases() throws Throwable {
		hp.clickCases();
		Thread.sleep(2000);
		String title=driver.getTitle();
		Assert.assertEquals(title,"Cases | firsttrial CRM");
	}
	
	@Test
	public void validateAddText() {
		hp.addTask();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
