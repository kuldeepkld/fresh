package com.crm.qa.pagespack;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.crm.qa.basepack.BaseClass;
import com.crm.qa.utilpack.DatePattern;

public class CalendarAndTasks extends BaseClass{
	
	@FindBy(xpath="//span[@class='calendar-header-list-tab-icon']")
	public WebElement taskButton;
	
	public void clickTaskButton() {
		taskButton.click();
	}
	
	
	@FindBys( {
		   @FindBy(xpath= "//span[@class='hyperlink general-task-item-title-text']")
	})
	public List<WebElement> ls;
	
	public boolean searchDescriptionInUpCommingTask(String description) {
		String name;
		boolean flag=false;
		for(WebElement a: ls) {
			 name= a.getText();
			if(name.equals(description))
			{ flag=true;
			break;}}
		return flag;}
	
	@FindBys( {
		   @FindBy(xpath= "//div[@class='task-date-time ember-view'][contains(.,',')]")
	})
	public List<WebElement> dateRecords;
	
	public boolean searchDateInUpCommingTask(String date, String hour, String minutes ) throws Throwable {
		String actualDate=DatePattern.getFormate2Date(date, hour, minutes);
		System.out.println(actualDate);
		boolean flag=false;
		for(WebElement a: dateRecords) {
			String printedDate= a.getText();
			System.out.println(printedDate);
			if(actualDate.equals(printedDate))
			{ flag=true;
			break;}}
		return flag;
	}
	
	public EditTask navigateToEditTask(String description) {
	String name;
	for(WebElement a: ls) {
		 name= a.getText();
		if(name.equals(description))
		{a.click();
		break;}}
	
	return new EditTask();}
}
	
	

