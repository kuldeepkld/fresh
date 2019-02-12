package com.crm.qa.testcasespack;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.qa.basepack.BaseClass;


@Listeners(com.crm.qa.utilpack.TestCommonUtiles.class)
public class ListenerTest extends BaseClass  {
	
	
	@BeforeMethod
	public void setup() throws Throwable {
		launchBrowser();
	}
	
	@Test
	public void testlistener() {
		
		System.out.println("test stared");
		Assert.assertEquals(1, 2);
		System.out.println("test ended");
		
	}
	

}
