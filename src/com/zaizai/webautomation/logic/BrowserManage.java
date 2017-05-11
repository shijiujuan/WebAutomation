package com.zaizai.webautomation.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.zaizai.webautomation.utils.Context;
import com.zaizai.webautomation.utils.ReadUtils;

public class BrowserManage {

	WebDriver dr;
	Context context = Context.getInstance();	
	String firefoxdriver = "webdriver.gecko.driver";
	String chromedriver = "webdriver.chrome.driver";
	String iedriver = "webdriver.ie.driver";
	String firefoxpath = ReadUtils.readProperties("/config.properties", "firefoxdriver");
	String chromepath = ReadUtils.readProperties("/config.properties", "chromedriver");
	String iepath = ReadUtils.readProperties("/config.properties", "iedriver");

	public void BrowserType() {
		context.setBrowserType(ReadUtils.readProperties("/config.properties", "Browser"));
		if (context.getBrowserType().toLowerCase().equals("firefox")) {
			System.setProperty(firefoxdriver, firefoxpath);
			dr = new FirefoxDriver();
		} else if (context.getBrowserType().toLowerCase().equals("chrome")) {
			System.setProperty(chromedriver, chromepath);
			dr = new ChromeDriver();
		} else if (context.getBrowserType().toLowerCase().equals("ie")) {
			System.setProperty(iedriver, iepath);
			dr = new InternetExplorerDriver();
		} else {
			System.setProperty(firefoxdriver, firefoxpath);
			dr = new FirefoxDriver();
		}
	}

}