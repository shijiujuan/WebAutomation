package com.zaizai.webautomation.logic;

import com.zaizai.webautomation.base.BaseWebDrvier;
import com.zaizai.webautomation.base.ImprovedWebDrvier;

public class LoginPage {

	/**
	 * 没有验证码的的登录
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param xpath
	 *            元素类型
	 * @param unameXpath
	 *            用户名的xpath路径
	 * @param uname
	 *            用户名
	 * @param pwdXpath
	 *            密码xpath路径
	 * @param pdrValue
	 *            密码
	 * @param loginBtnXpath
	 *            登录按钮xpath
	 */
	public static void login(BaseWebDrvier dr, String url, String xpath, String unameXpath, String uname,
			String pwdXpath, String pwd, String loginBtnXpath,String loginBtn) {
		dr.get(url);
		ImprovedWebDrvier.inputs(dr, xpath, unameXpath, uname);
		ImprovedWebDrvier.inputs(dr, xpath, pwdXpath, pwd);
		ImprovedWebDrvier.click(dr, loginBtnXpath,loginBtn);
	}

	/**
	 * 登录可能放在一个frame里了：我是因为遇到过，所以才加了个方法的
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param unameXpath
	 *            用户名的xpath路径
	 * @param uname
	 *            用户名
	 * @param pwdXpath
	 *            密码xpath路径
	 * @param pwd
	 *            密码
	 * @param loginBtnXpath
	 *            登录按钮xpath
	 * @param frame
	 *            第几个框架
	 */
	public static void loginFrame(BaseWebDrvier dr, String url, String xpath, String unameXpath, String uname,
			String pwdXpath, String pwd, String loginBtnXpath,String loginBtn, int frame) {
		dr.get(url);
		dr.switchTo().frame(frame);
		ImprovedWebDrvier.inputs(dr, xpath, unameXpath, uname);
		ImprovedWebDrvier.inputs(dr, xpath, pwdXpath, pwd);
		ImprovedWebDrvier.click(dr, loginBtnXpath,loginBtn);
	}

	/**
	 * 有验证码的登录
	 * 
	 * @param dr
	 *            BaseWebDrvier对象
	 * @param unameXpath
	 *            用户名的xpath路径
	 * @param uname
	 *            用户名
	 * @param pdrXpath
	 *            密码xpath路径
	 * @param pdrValue
	 *            密码
	 * @param loginBtnXpath
	 *            登录按钮xpath
	 * @param seconds
	 *            输入验证码的间隔
	 */
	public static void loginVerify(BaseWebDrvier dr, String url, String xpath, String unameXpath, String uname,
			String pdrXpath, String pdr, String loginBtnXpath,String loginBtn, int seconds) {
		dr.get(url);
		ImprovedWebDrvier.inputs(dr, xpath, unameXpath, uname);
		ImprovedWebDrvier.inputs(dr, xpath, pdrXpath, pdr);
		try {
			Thread.sleep(seconds * 1000); // 这段时间内请输入验证码
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ImprovedWebDrvier.click(dr, loginBtnXpath,loginBtn);
	}
}
