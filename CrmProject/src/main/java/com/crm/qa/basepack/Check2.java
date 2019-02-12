package com.crm.qa.basepack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Drivers/Chrom.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		

	}

}
