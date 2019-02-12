package com.crm.qa.utilpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.crm.qa.basepack.BaseClass;



public class TestCommonUtiles extends BaseClass implements ITestListener{
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\kullu\\Downloads\\maven Selenium\\CrmProject\\src\\main"
			+ "\\java\\com\\crm\\qa\\testdatapack\\CrmProjectTestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 Sheet	sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	//year, month day methods
		public static String getYear(String date) {
			String year=date.substring(7,11);
			return year;
		}
		public static String getMonth(String date) {
			String month=date.substring(3,6);
			return month;
		}
		public static String getDay(String date) {
			String day;
			if(date.charAt(0)=='0') {
				 day= date.substring(1,2);}
			else {
				 day=date.substring(0,2);
			}
			return day;
		}
		
		// hour and minute methods.
		public static String getHour(String hour) {
			String h=hour.substring(0,2);
			String h1;
			if (h.charAt(1)=='.') 
				h1="0"+hour.substring(0,1);
			else
				h1=h;
			return h1;
			}
		
		public static String getMinutes(String minutes) {
			String m=minutes.substring(0,2);
			String m1;
			if (m.charAt(1)=='.') 
				m1="0"+minutes.substring(0,1);
			else
				m1=m;
			return m1;}
		
		public static String getFormate1Date(String date) throws Throwable {
			
			String date1= date;
			Date dateO1= new SimpleDateFormat("dd-MMM-yyyy").parse(date1);
			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");  
		    String formatedDate = formatter1.format(dateO1);
			return formatedDate;
			
		}
		public static String getFormate2Date(String date, String hour, String minutes) throws Throwable {
			
			String anotherFormDate= date+" "+getHour(hour)+":"+getMinutes(minutes);
			Date dateO2= new SimpleDateFormat("dd-MMM-yyyy hh:mm").parse(anotherFormDate);
			SimpleDateFormat formatter2 = new SimpleDateFormat("E,dd MMM, hh:mm");  
		    String anotherFormatedDate = formatter2.format(dateO2);
			return anotherFormatedDate;  
			
		}
		// select element from webelements list method
		public static void selectListElement(List<WebElement> list , String Category) {
			
			for(int i=0; i<=list.size()-1; i++)
			{
				if (list.get(i).getText().equals(Category))
					{list.get(i).click();
					break;
					}
			}}	
		
		
		public static void selectMethod(WebElement wb, String year) {
			Select sel=new Select(wb);
			sel.selectByVisibleText(year);
			
		}
		
		public void clickOn(WebDriver driver, WebElement element, int time) {
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
			element.click();
		}
		
		
		
		@Override
		public void onFinish(ITestContext arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onStart(ITestContext arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onTestFailure(ITestResult argument) {
			String testName= argument.getMethod().getMethodName();
			EventFiringWebDriver edriver= new EventFiringWebDriver (driver);
			File sourceFile= edriver.getScreenshotAs(OutputType.FILE);
			File destinationFile= new File("./screenshot/"+testName+".png");
			try {
				FileUtils.copyFile(sourceFile, destinationFile);
			} catch (IOException e) {
				System.out.println("exception occured");
				e.printStackTrace();
			}
			
		}
		@Override
		public void onTestSkipped(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onTestStart(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onTestSuccess(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public static void selectValueFromDropDown(String value, WebElement wb) {
			Select sl1= new Select(wb);
			sl1.selectByVisibleText(value);
		}
		
}
