package com.crm.qa.testcasespack;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basepack.BaseClass;
import com.crm.qa.pagespack.AddTaskPage;
import com.crm.qa.pagespack.CalendarAndTasks;
import com.crm.qa.pagespack.HomePage;
import com.crm.qa.pagespack.LoginPage;

public class checkTest extends BaseClass {
	
	public LoginPage lp;
	public HomePage hp;
	public AddTaskPage ad;
	public CalendarAndTasks cat;
	
	@BeforeMethod
	public void setUp() throws Throwable {
		launchBrowser();
		
		lp=PageFactory.initElements(driver,LoginPage.class);
		hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
		hp= PageFactory.initElements(driver,HomePage.class);
				
	}
	
	@Test() 
	public void validateOtherDetailsOfAddTaskEntryForm() throws Throwable {
		cat=hp.clickCalendarAndTasks();
		cat=PageFactory.initElements(driver, CalendarAndTasks.class);
		cat.clickTaskButton();
		List <WebElement> ls=driver.findElements(By.xpath(("//div[@class='tasks-list-row']/div[1]")));
		String b= "ghvhv";
		WebElement wb=driver.findElement(By.xpath("//div[@class='tasks-list-row']/div[1]/div[1]"));
		for(WebElement a: ls) {
		String s=a.getText();
		if (b.equals(s))
			wb.click();}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
	
	
	

		


