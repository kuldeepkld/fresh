package com.crm.qa.pagespack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.basepack.BaseClass;

public class EditTask extends BaseClass {
	
	
	
	@FindBy(xpath = "//button[contains(.,'Complete task')]/../button[2]")
	WebElement deleteTaskButton;
	
	public void deleteAddTask() {
		deleteTaskButton.click();
	}

}
