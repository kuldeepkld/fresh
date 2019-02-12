package com.crm.qa.utilpack;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.crm.qa.basepack.BaseClass;

public class DatePattern extends BaseClass {
	
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
			
			public static String getFormatedDate(String date, String newFormate) throws Throwable {
				
				String date1= date;
				Date dateO= new SimpleDateFormat("dd-MMM-yyyy").parse(date);
				SimpleDateFormat formatter = new SimpleDateFormat(newFormate);  
			    String formatedDate = formatter.format(dateO);
				return formatedDate;
				
			}
			public static String getFormate2Date(String date, String hour, String minutes) throws Throwable {
				
				String anotherFormDate= date+" "+getHour(hour)+":"+getMinutes(minutes);
				Date dateO2= new SimpleDateFormat("dd-MMM-yyyy hh:mm").parse(anotherFormDate);
				SimpleDateFormat formatter2 = new SimpleDateFormat("E, dd MMM, HH:mm");  
			    String anotherFormatedDate = formatter2.format(dateO2);
				return anotherFormatedDate;  
				
			}
			
	


}


