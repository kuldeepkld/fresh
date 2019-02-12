package com.crm.qa.basepack;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pagespack.AddTaskPage;
import com.crm.qa.pagespack.HomePage;
import com.crm.qa.pagespack.LoginPage;
import com.crm.qa.utilpack.TestCommonUtiles;

public class check {
	
	
	
	public static Properties prop;
	public static WebDriver driver;
	public LoginPage lp;
	public HomePage hp;
	public AddTaskPage ad;
	@BeforeMethod	
	public void launchBrowser() throws Throwable {	
		
		FileInputStream fis = new FileInputStream("./src/main/java/com/crm/configpack/Source.properties");
		 prop = new Properties();
		prop.load(fis);
		String bNAme = prop.getProperty("browser");
		System.out.println("browserNAme======>"+bNAme);
		
		System.out.println("====launch the Browser=====");
		if(bNAme.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", 
					"./Drivers/geckodriver.exe");
		 driver = new FirefoxDriver();
		}else if(bNAme.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(bNAme.equals("ie")){
			System.setProperty("webdriver.ie.driver",
					"./src/main/resources/resource/IEDriverserver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
	
	@BeforeMethod	
		public void setUp() throws Throwable {
			//launchBrowser();
			lp=PageFactory.initElements(driver,LoginPage.class);
			hp=lp.Login(prop.getProperty("username"),prop.getProperty("password"));
			hp= PageFactory.initElements(driver,HomePage.class);
			
		}
		
		@Test(dataProvider="getCRMTestData")
		
		public void validateCheck1(String Description, String date, String hour, String minutes, String Category) throws Throwable {
			ad=hp.addTask();
			driver.findElement(By.xpath("//input[@class='form-input-text task-description']")).sendKeys(Description);
			// xl data shaping for date
			String day;
			if(date.charAt(0)=='0') {
				 day= date.substring(1,2);}
			else {
				 day=date.substring(0,2);
			}
			String month=date.substring(3,6);
			String year=date.substring(7,11);
			
			// for date
			driver.findElement(By.xpath("//input[@class='task-due-date date-picker simple ember-view']")).click();
			driver.findElement(By.xpath("//button[text()='14']")).click();
			
			
			// selection of year
			driver.findElement(By.xpath("//input[@class='task-due-date date-picker simple ember-view']")).click();
			driver.findElement(By.xpath("//div[@class='pika-label'][2]")).click();
			WebElement wb=driver.findElement(By.xpath("//select[@class='pika-select pika-select-year']"));
			Select sel=new Select(wb);
			sel.selectByVisibleText(year);
			
			
			//selection of month and date
			driver.findElement(By.xpath("//div[@class='pika-label'][1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='pika-label'][1]/select//option[contains(text(),'"+ month + "')]")).click();
			driver.findElement(By.xpath("//button[text()='"+ day+ "']")).click();
			
			// xl data shaping for hour and minutes
			String h=hour.substring(0,2);
			String h1;
			if (h.charAt(1)=='.') 
				h1=hour.substring(0,1);
			else
				h1=h;
			System.out.println(h1);
			String m=minutes.substring(0,2);
			String m1;
			if (m.charAt(1)=='.') 
				m1="0"+minutes.substring(0,1);
			else
				m1=m;
			
			// select and click hour and minutes value after data shaping
			driver.findElement(By.xpath("//div[@class='time-select ember-view']/div[1]/select[1]//option[@value='"+ h1+ "']")).click();
			driver.findElement(By.xpath("//div[@class='time-select ember-view']/div[2]/select[1]//option[text()='"+ m1+ "']")).click();
			
			// creation of category list and selection of category 
			driver.findElement(By.xpath("//div[text()='None' and @class='single-select-selected-option ember-view']")).click();
			List<WebElement> list =driver.findElements(By.xpath("//div[@role='listbox']//div"));
			for(int i=0; i<=list.size()-1; i++)
			{
				if (list.get(i).getText().equals(Category))
					{list.get(i).click();
					break;
					}
			}
		// click on save button
	//	driver.findElement(By.xpath("//button[text()='Save']")).click();
			Thread.sleep(3000);// this wait to see the task
			driver.close();
		
	}
		@DataProvider
		public Object[][] getCRMTestData(){
			Object data[][] = TestCommonUtiles.getTestData("Sheet1");
			return data;
		}
		public void clickOn(WebDriver driver, WebElement element, int time) {
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
			element.click();
		}
}
