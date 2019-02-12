package com.crm.qa.pagespack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.basepack.BaseClass;

public class PeopleAndOrganisations extends BaseClass{
	
	@FindBy(xpath="//a[@class='btn-secondary btn-small ember-view']")
	public WebElement addPerson;
	
	public void clickAddPerson() {
		addPerson.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'New Person')]")
	public WebElement titleNewPerson;
	
	public String title() {
		String title=titleNewPerson.getText();
		return title;
	}
	@FindBy (xpath="//select[@name='party:j_id107:j_id115']")
	public WebElement titleDropDown;
	
	@FindBy(xpath="//span[@class='input ']")
	public WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@id='party:lnDecorate:ln']")
	public WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@id='party:roleDecorate:jobTitle']")
	public WebElement jobTitleTextBox;
	
	@FindBy(xpath="//input[@id='party:orgDecorate:org']")
	public WebElement organisationTextBox;
	
	@FindBy(xpath="//input[@id='party:tagsDecorate:tagComboBox']")
	public WebElement tagsTextBox;
	
	@FindBy(xpath="//input[@id='party:j_id324:0:phnDecorate:number']")
	public WebElement phoneNumberTextBox;
	
	@FindBy(xpath="//select[@name='party:j_id324:0:phnDecorate:j_id327']")
	public WebElement mobileDropDown;
	
	@FindBy(xpath="//input[@id='party:j_id341:0:emlDecorate:nmbr']")
	public WebElement emailAdressTextBox;
	
	@FindBy(xpath="//input[@type='text'][@name='party:j_id341:0:emlDecorate:nmbr']")
	public WebElement emailAdressType;
	
	@FindBy(xpath="//input[@id='party:j_id369:0:webDecorate:web']")
	public WebElement websitesTextBox;
	
	@FindBy(xpath="//input[@type='text'][@name='party:j_id369:0:webDecorate:web']")
	public WebElement websitesDropDown;
	
	@FindBy(xpath="//input[@type='text'][@name='party:j_id369:0:webDecorate:web']")
	public WebElement websitesType;
	
	@FindBy(xpath="//span[contains(text(),'Ad‌d an ad‌dress')]")
	public WebElement addAdresslink;
	
	@FindBy(xpath="//textarea[@id='party:j_id388:0:strDecorate:str']")
	public WebElement addAdress;
	
	@FindBy(xpath="//input[@id='party:save']")
	public WebElement saveBtn;
	
	public void addNewPerson(String firstName, String lastName, String jobTitle, String organisation, 
			String tags, String phoneNumber, String email, String website, String address ) throws Throwable {
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		firstNameTextBox.click();
		js.executeScript("document.getElementById('party:fnDecorate:fn').value='"+firstName+"';");
		lastNameTextBox.click();
		js.executeScript("document.getElementById('party:lnDecorate:ln').value='"+lastName+"';");
		jobTitleTextBox.click();
		js.executeScript("document.getElementById('party:roleDecorate:jobTitle').value='"+jobTitle+"';");
		organisationTextBox.click();
		js.executeScript("document.getElementById('party:orgDecorate:org').value='"+organisation+"';");
		tagsTextBox.click();
		js.executeScript("document.getElementById('party:tagsDecorate:tagComboBox').value='"+tags+"';");
		phoneNumberTextBox.click();
		js.executeScript("document.getElementById('party:j_id324:0:phnDecorate:number').value='"+phoneNumber+"';");
		emailAdressTextBox.click();
		js.executeScript("document.getElementById('party:j_id341:0:emlDecorate:nmbr').value='"+email+"';");
		websitesTextBox.click();
		js.executeScript("document.getElementById('party:j_id369:0:webDecorate:web').value='"+website+"';");
		addAdresslink.click();
		addAdress.click();
		js.executeScript("document.getElementById('party:j_id388:0:strDecorate:str').value='"+address+"';");
		Thread.sleep(4000);
		saveBtn.click();
		
//		firstNameTextBox.sendKeys(firstName);
//		lastNameTextBox.sendKeys(lastName);
//		jobTitleTextBox.sendKeys(jobTitle);
//		organisationTextBox.sendKeys(organisation);
//		tagsTextBox.sendKeys(tags);
//		phoneNumberTextBox.sendKeys(phoneNumber);
//		emailAdressTextBox.sendKeys(email);
//		websitesTextBox.sendKeys(website);
//		addAdress.sendKeys(address);
		
	}

}
