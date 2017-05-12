package com.zaizai.webautomation.base;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;

public class ImprovedWebDrvier {

	/**
	 * 获取元素节点的文本值
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @param value
	 *            元素类型
	 * @return
	 */
	public static String getText(BaseWebDrvier dr, String xpath, String value) {
		return dr.findElement(xpath, value).getText();
	}

	/**
	 * 获取元素节点的文本值
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @return 没有找到该元素时会有个提示，并且不会报错，建议使用
	 */
	public static String getExistText(BaseWebDrvier dr, String xpath, String value, String type) {
		if (isExist(dr, xpath, value)) {
			return getText(dr, xpath, type);
		}
		return "-1";
	}

	/**
	 * 获取元素节点的属性值
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @attribute 要获取目标节点的哪个属性
	 * @return
	 */
	public static String getAttribute(BaseWebDrvier dr, String xpath, String value, String attribute) {
		return dr.findElement(xpath, value).getAttribute(attribute);
	}

	/**
	 * 点击节点
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @return
	 */
	public static void click(BaseWebDrvier dr, String xpath,String value) {
		dr.findElement(xpath,value).click();
	}

	/**
	 * 输入文本
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @return
	 */
	public static void inputs(BaseWebDrvier dr, String xpath, String value1, String value2) {
		dr.findElement(xpath, value1).sendKeys(value2);
		// dr.findElement(By.xpath(xpath)).sendKeys(value);
	}

	/**
	 * 判断是否选中
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @param value
	 *            元素页面中的位置
	 * @return
	 */
	public static boolean isChecked(BaseWebDrvier dr, String xpath, String value) {
		return dr.findElement(xpath, value).isSelected();
	}

	/**
	 * 判断是否可用
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @param value
	 *            元素页面中的位置
	 * @return
	 */
	public static boolean isEnabled(BaseWebDrvier dr, String xpath, String value) {
		return dr.findElement(xpath, value).isEnabled();
	}

	/**
	 * 判断是否存在元素
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 * @param value
	 *            元素页面中的位置
	 * @return
	 */
	public static boolean isExist(BaseWebDrvier dr, String xpath, String value) {
		try {
			dr.findElement(xpath, value);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 选中复选框,其实和点击一样，只是重新起了个名字
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            读取配置文件中的key
	 */
	public static void check(BaseWebDrvier dr, String xpath,String value) {
		click(dr, xpath,value);
	}

	/**
	 * 点击那种隐藏的下拉框
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath1
	 *            事件源节点的xpath
	 * @param xpath2
	 *            事件源节点的xpath
	 */
	public static void clickHidden(BaseWebDrvier dr, String xpath1, String xpath2,String value1,String value2) {
		click(dr, xpath1,value1);
		click(dr, xpath2,value2);
	}

	/**
	 * 获取隐藏的文本，原理同上
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath1
	 *            事件源节点的xpath
	 * @param xpath2
	 *            读取配置文件中的key
	 */
	public static void getHiddenText(BaseWebDrvier dr, String xpath1, String xpath2, String value1,String value2) {
		click(dr, xpath1,value1);
		getText(dr, xpath2, value2);
	}

	/**
	 * 获取隐藏节点的属性值
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath1
	 *            事件源节点的xpath
	 * @param xpath2
	 *            读取配置文件中的key
	 * @param value
	 *            元素页面中的位置
	 * @param attribute
	 *            要获取目标节点的哪个属性
	 */
	public static String getHiddenAttribute(BaseWebDrvier dr, String xpath1, String xpath2, String value1,String value2,
			String attribute) {
		click(dr, xpath1,value1);
		return getAttribute(dr, xpath2, value2, attribute);
	}

	/**
	 * 切换窗口
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param title
	 *            要切换窗口的标题
	 */
	public static void changeWindow(BaseWebDrvier dr, String title) {
		String current = dr.getWindowHandle();
		Set<String> all = dr.getWindowHandles();
		Iterator<String> iterator = all.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (handle.equals(current)) {
				continue;
			} else {
				dr.switchTo().window(handle);
				if (dr.getTitle().contains(title)) {
					System.out.println("窗口成功跳转");
					break;
				} else {
					continue;
				}
			}
		}
	}
}
