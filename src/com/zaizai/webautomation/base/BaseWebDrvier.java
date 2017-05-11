package com.zaizai.webautomation.base;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebDrvier extends AWebDriver {

	WebDriver dr;

	@Override
	public void close() {
		// TODO Auto-generated method stub
		dr.close();
	}

	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void get(String url) {
		// TODO Auto-generated method stub
		try {
			if (url != null && url.contains("http")) {
				dr.get(url);
			} else {
				throw new Exception("url为空");
			}
		} catch (Exception e) {
		}
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		if (dr.getCurrentUrl() != null) {
			return dr.getCurrentUrl();
		} else {
			return null;
		}
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		if (dr.getPageSource() != null) {
			return dr.getPageSource();
		} else {
			return null;
		}
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		if (dr.getTitle() != null) {
			return dr.getTitle();
		} else {
			return null;
		}
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		if (dr.getWindowHandle() != null) {
			return dr.getWindowHandle();
		} else {
			return null;
		}
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		if (dr.getWindowHandles() != null && dr.getWindowHandles().size() >= 0) {
			return dr.getWindowHandles();
		} else {
			return null;
		}
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return dr.manage();
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return dr.navigate();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		dr.quit();
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return dr.switchTo();
	}
	
	public WebElement findElement(String by, String value) {
		// TODO Auto-generated method stub
		switch (by.toLowerCase()) {
		case "xpath":
			return findElement(By.xpath(value));
		case "id":
			return findElement(By.id(value));
		case "linkText":
			return findElement(By.linkText(value));
		case "name":
			return findElement(By.name(value));
		case "className":
			return findElement(By.className(value));
		case "cssSelector":
			return findElement(By.cssSelector(value));
		case "partialLinkText":
			return findElement(By.partialLinkText(value));
		case "tagName":
			return findElement(By.tagName(value));
		}
		return null;
	}

	public List<WebElement> findElements(String by, String value) {
		// TODO Auto-generated method stub
		switch (by.toLowerCase()) {
		case "xpath":
			return findElements(By.xpath(value));
		case "id":
			return findElements(By.id(value));
		case "linkText":
			return findElements(By.linkText(value));
		case "name":
			return findElements(By.name(value));
		case "className":
			return findElements(By.className(value));
		case "cssSelector":
			return findElements(By.cssSelector(value));
		case "partialLinkText":
			return findElements(By.partialLinkText(value));
		case "tagName":
			return findElements(By.tagName(value));
		}
		return null;
	}

	//设置浏览器窗口大小
	public void browserSize(int wide, int high) {
		if (wide != 0 && high != 0) {
			dr.manage().window().setSize(new Dimension(wide, high));
		} else {
			dr.manage().window().maximize();
		}
	}

	// 全局元素等待，触发等待不适用
	public void waitElement(int wait) {
		dr.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	// 等待元素并返回布尔值
	public Boolean waitElement(WebDriver dr, int wait, By by) {
		return (new WebDriverWait(dr, wait)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				return dr.findElement(by).isDisplayed();
			}
		});
	}

	// 等待元素并返回值(用于获取数据)
	public String waitElementString(WebDriver dr, int wait, By by) {
		return (new WebDriverWait(dr, wait)).until(new ExpectedCondition<String>() {
			public String apply(WebDriver dr) {
				return dr.findElement(by).getText().toString();
			}
		});
	}

}
