package com.crm.qa.pagespack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.basepack.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(name="login:usernameDecorate:username")
	public WebElement userEdt;
	
	@FindBy(name="login:passwordDecorate:password")
	public WebElement passwordEdt;
	
	@FindBy(name="login:login")
	public WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='Capsule']")
	public WebElement crmLogo;
	
	@FindBy(id="cannot-access-account")
	public WebElement forgotPasswordLink;
	
	@FindBy(id="login:rememberMeDecorate:rememberMe")
	public WebElement rememberUserName;
	
	//Initializing the Page Objects:
//	public LoginPage() {
//		PageFactory.initElements(driver, LoginPage.class);
//	}
//	
	//Actions
	public String loginPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	public boolean loginLogo() {
		return crmLogo.isDisplayed();
	}
	public boolean rememberUserName() {
		boolean isChecked= rememberUserName.isSelected();
		return isChecked;
	}
	public HomePage Login(String username, String password) {
		userEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		return new HomePage();
	}
	

}
