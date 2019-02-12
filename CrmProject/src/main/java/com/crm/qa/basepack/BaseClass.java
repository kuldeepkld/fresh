package com.crm.qa.basepack;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	
	public BaseClass() {
	
	}	
	public void launchBrowser() throws Throwable {	
		
		FileInputStream fis = new FileInputStream("./src/main/java/com/crm/configpack/Source.properties");
		 prop = new Properties();
		prop.load(fis);
		String bNAme = prop.getProperty("browser");
		System.out.println("browserNAme "+bNAme);
		
		System.out.println("launch the Browser");
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
					"./Drivers/IEDriverserver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
	
	
		
		
		


}

	
	