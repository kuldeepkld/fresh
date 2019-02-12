package com.crm.qa.pagespack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.basepack.BaseClass;
import com.crm.qa.utilpack.DatePattern;
import com.crm.qa.utilpack.TestCommonUtiles;

public class AddTaskPage extends BaseClass{

	@FindBy(xpath="//header[@class='modal-dialog-header']")
	public WebElement addTaskHader;
	
	@FindBy(xpath="//input[@class='form-input-text task-description']")
	public WebElement descriptionButton;
	
	@FindBy(xpath = "//input[@placeholder='dd/mm/yy']")
	public WebElement dateCalender;
	
	@FindBy(xpath="//div[@class='pika-label'][1]")
			public WebElement monthe;
	@FindBy(xpath="//div[@class='pika-label'][2]")
	public WebElement year;
	
	@FindBy(xpath="//input[@class='form-input-text task-description']")
	public WebElement inputDescription;
	
	@FindBy(xpath="//input[@placeholder='dd/mm/yy']")
	public WebElement dateTextBox;
	
	@FindBy(xpath="//button[text()='14']")
	public WebElement pickDateButton;
	
	@FindBy(xpath="//div[@class='pika-label'][2]")
	public WebElement yearDropDown;
	
	@FindBy(xpath="//select[@class='pika-select pika-select-year']")
	public WebElement yearWebElement;
	
	@FindBy(xpath="//div[@class='pika-label'][1]")
	public WebElement monthDropDown;
	
	@FindBy(xpath="//div[text()='None' and @class='single-select-selected-option ember-view']")
	public WebElement categoryButton;
	
	@FindBy(xpath="//label[contains(.,'Time')]/../../div[2]/div[1]/select")
	public WebElement hourButton;
	
	@FindBy(xpath= "//label[contains(.,'Time')]/../../div[2]/div[2]/select")
	public WebElement minute1;
	
	@FindBy(xpath= "//input[contains(@placeholder,'dd/mm/yy')]")
	public WebElement dateTextbox1;
	
	@FindBys( {
		   @FindBy(xpath= "//div[@role='listbox']//div")
	})
	public List<WebElement> list;
	
	public HomePage fillTask(String Description, String date, String hour, String minutes, String Category) throws Throwable  {
		
		String formatedHour=TestCommonUtiles.getHour(hour);
		String formatedMinutes=TestCommonUtiles.getMinutes(minutes);
		inputDescription.sendKeys(Description);
		dateTextBox.click();
		String a=DatePattern.getFormatedDate(date, "dd/MM/yyyy");
		dateTextBox.sendKeys(a);
		hourButton.click();
		TestCommonUtiles.selectValueFromDropDown(formatedHour,hourButton);
		minute1.click();
		TestCommonUtiles.selectValueFromDropDown(formatedMinutes,minute1);
		categoryButton.click();
		TestCommonUtiles.selectListElement(list, Category);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		return new HomePage();
		
	}			
	}
	

