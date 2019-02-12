package com.crm.qa.pagespack;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.basepack.BaseClass;

public class HomePage extends BaseClass {
	
	
	@FindBy(xpath="//a[@aria-label='Dashboard']")
	public WebElement dashBoard;
	
	public HomePage dashBoardButton() {
		dashBoard.click();
		return new HomePage();	
	}
	
	@FindBy (xpath="//a[@aria-label='People & Organisations']")
	public WebElement peopleAndOrganisations;
	
	public  PeopleAndOrganisations peopleAndOrganisations() {
		peopleAndOrganisations.click();
		return new PeopleAndOrganisations();	
	}
	
	@FindBy (xpath="//a[@aria-label='Calendar & Tasks']")
	public WebElement calendarTasks;
	
	public  CalendarAndTasks clickCalendarAndTasks() throws Throwable {
		calendarTasks.click();
		return new CalendarAndTasks();
	}
	
	@FindBy (xpath="//a[@aria-label='Sales Pipeline']")
	public WebElement salesPipeline;
	
	public  SalesPipeline clickSalesPipeline() {
		salesPipeline.click();
		return new SalesPipeline();
	}
	
	@FindBy (xpath="//a[@aria-label='Cases']")
	public WebElement cases;
	
	public  Cases clickCases() {
		cases.click();
		return new Cases();
	}
	
	@FindBy (xpath="//span[text()='Add']")
	public WebElement addButton;
	
	public  void clickAddButton() {
		addButton.click();	
	}
	
	@FindBy(xpath= "//button[contains(text(),'Add Task')]")
	public WebElement addTaskButton;
	
	public AddTaskPage addTask() {
		addTaskButton.click();
		return new AddTaskPage();
	}
	
	
	
	
	
	

}
