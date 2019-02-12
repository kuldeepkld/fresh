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
import com.crm.qa.pagespack.EditTask;
import com.crm.qa.pagespack.HomePage;
import com.crm.qa.pagespack.LoginPage;
import com.crm.qa.utilpack.TestCommonUtiles;


@Listeners(com.crm.qa.utilpack.TestCommonUtiles.class)
public class AddTaskPageTest extends  BaseClass{
	
	public LoginPage lp;
	public HomePage hp;
	public AddTaskPage ad;
	public CalendarAndTasks cat;
	public EditTask et;
	
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		
		lp=PageFactory.initElements(driver,LoginPage.class);
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
		hp= PageFactory.initElements(driver,HomePage.class);			
	}

	@Test(dataProvider="getCRMTestData", priority= 0)
		public void submitAddTask(String Description, String date, String hour, String minutes, String Category) throws Throwable {
		ad=hp.addTask();
		ad= PageFactory.initElements(driver,AddTaskPage.class);
		hp=ad.fillTask(Description, date, hour, minutes, Category);
		
	}

	@Test(dataProvider="getCRMTestData",dependsOnMethods="submitAddTask",priority= 1)
			public void validateAddTaskDescription(String Description, String date, String hour, String minutes, String Category) throws Throwable {
			cat=hp.clickCalendarAndTasks();
			cat=PageFactory.initElements(driver, CalendarAndTasks.class);
			cat.clickTaskButton();
			Assert.assertTrue(cat.searchDescriptionInUpCommingTask(Description));}
		
	@Test(dataProvider="getCRMTestData",dependsOnMethods="submitAddTask",priority= 1) 
		public void validateAddTaskDate(String Description, String date, String hour, String minutes, String Category) throws Throwable {
			cat=hp.clickCalendarAndTasks();
			cat=PageFactory.initElements(driver, CalendarAndTasks.class);
			cat.clickTaskButton();
			Assert.assertTrue(cat.searchDateInUpCommingTask(date, hour, minutes));		
		}
	@Test(dataProvider="getCRMTestData",dependsOnMethods= "validateAddTaskDescription", priority= 2)
		public void deleteTask(String Description, String date, String hour, String minutes, String Category) throws Throwable {
			cat=hp.clickCalendarAndTasks();
			cat=PageFactory.initElements(driver, CalendarAndTasks.class);
			cat.clickTaskButton();
			EditTask et=cat.navigateToEditTask(Description);
			et=PageFactory.initElements(driver, EditTask.class);
			et.deleteAddTask();	
		}
		
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestCommonUtiles.getTestData("Sheet1");
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
