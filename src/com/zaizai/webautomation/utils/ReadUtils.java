package com.zaizai.webautomation.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadUtils {

	/**
	 * 读取Properties文件
	 * 
	 * @param config
	 *            配置文件名称和后缀
	 * @param key
	 *            配置文件中的key
	 * @return 配置文件中key对应的vale，没有数据时返回空
	 */
	public static String readProperties(String config, String key) {
		Properties pro = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + config));
			pro.load(in);
			String vale = pro.getProperty(key);// key是配置文件里定义的
			return vale;
		} catch (Exception e) {
			EorrLog.Log("读配置文件报错。" + e.toString());
			return null;
		}
	}

	/**
	 * 读取文件
	 * 
	 * @param config
	 *            配置文件名称和后缀
	 * @return 返回数据为字符串类型
	 */
	public static String readFile(String config) {
		BufferedReader reader = null;
		String str = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + config);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				str += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	/**
	 * 读取文件
	 * 
	 * @param path
	 *            配置文件路径
	 * @param config
	 *            配置文件名称和后缀
	 * @return 返回数据为字符串类型
	 */
	public static String readFile(String path, String config) {
		BufferedReader reader = null;
		String str = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(path + config);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				str += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}
}
