package com.zaizai.webautomation.testcase;

import org.testng.annotations.Test;

import com.zaizai.webautomation.logic.BrowserManage;
import com.zaizai.webautomation.utils.Context;
import com.zaizai.webautomation.utils.JsonUtils;
import com.zaizai.webautomation.utils.ReadUtils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class Case {

	WebDriver dr;
	// private static String jsonpath
	// =ReadUtils.readProperties("config.properties", "jsonpath");
	// private static String json = ReadUtils.readFile(jsonpath);

	// @BeforeMethod
	public void beforeMethod() {
		// dr=Driver.getDriver(dr);
	}

	@Test
	public void f001() throws Exception {
//		Context.getInstance().setBrowserType("Browser");
//		System.out.println(Context.getInstance().getBrowserType());
		BrowserManage bm = new BrowserManage();
		bm.BrowserType();
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