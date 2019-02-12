package com.crm.qa.testcasespack;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.basepack.BaseClass;
import com.crm.qa.pagespack.AddTaskPage;
import com.crm.qa.pagespack.CalendarAndTasks;
import com.crm.qa.pagespack.HomePage;
import com.crm.qa.pagespack.LoginPage;
import com.crm.qa.pagespack.PeopleAndOrganisations;
import com.crm.qa.utilpack.TestCommonUtiles;




@Listeners(com.crm.qa.utilpack.TestCommonUtiles.class)
public class PeopleAndOrganisationsTest extends BaseClass {
	
	public LoginPage lp;
	public HomePage hp;
	public PeopleAndOrganisations pao;
	
	

	@BeforeMethod
	public void setUp() throws Throwable {
	launchBrowser();
	lp=PageFactory.initElements(driver,LoginPage.class);
	hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
	hp= PageFactory.initElements(driver,HomePage.class);
	pao=hp.peopleAndOrganisations();
	pao=PageFactory.initElements(driver, PeopleAndOrganisations.class);
	}

	
	@Test
	public void validateAddPerson() {
		pao.clickAddPerson();
		String tit=pao.title();
		String title= tit.trim();
		Assert.assertEquals(title,"New Person");
	}
	
	@Test(dataProvider="getAddPersonDetail")
	public void addNewPersonTest(String firstName, String lastName, String jobTitle, String organisation,String tags, String phoneNumber, String email, String website, String address) throws Throwable {
		pao.clickAddPerson();
		Thread.sleep(1000);
		pao.addNewPerson(firstName, lastName, jobTitle, organisation,tags, phoneNumber, email, website, address);
		
	}
	@DataProvider
	public Object[][] getAddPersonDetail(){
		Object data[][] = TestCommonUtiles.getTestData("Sheet2");
		return data;	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	

}
