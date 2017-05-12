package com.zaizai.webautomation.testcase;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Case {

	WebDriver dr;

	// @BeforeMethod
	public void beforeMethod() {
		// dr=Driver.getDriver(dr);
	}

	@Test
	public void f001() throws Exception {
//		Context.getInstance().setBrowserType("Browser");
//		System.out.println(Context.getInstance().getBrowserType());
		Reporter.log("11111111");
	}

	// @Test
	public void f002() throws Exception {
		// EZlink.print();
		System.out.println("f002");
		Reporter.log("f002");
	}

//	public void f003() throws Exception {
//		System.out.println("f003");
//		Reporter.log("f003");
//	}

	// @AfterMethod
	public void afterMethod() {
		dr.quit();
	}
}