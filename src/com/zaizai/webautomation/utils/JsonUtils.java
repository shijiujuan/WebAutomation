package com.zaizai.webautomation.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtils {

	// private static String jsonpath
	// =ReadUtils.readProperties("/config.properties", "jsonpath");
	// private static String json = ReadUtils.readFile(jsonpath);

	/**
	 * 转JSON对象
	 * 
	 * @param json
	 *            传JSON数据
	 * @return
	 */
	public static JSONObject getJsonObject(String json) {
		JSONObject jsonobject = JSONObject.fromObject(json);
		return jsonobject;
	}

	/**
	 * 获取JSON某个字段的值，返回int类型
	 * 
	 * @param json
	 *            传JSON数据
	 * @param key
	 *            传json中的字段
	 * @return 返回int类型的值
	 */
	public static int getInt(String json, String key) {
		JSONObject jsonobject = JSONObject.fromObject(json);
		return jsonobject.getInt(key);
	}

	/**
	 * 获取JSON某个字段的值，返回String类型
	 * 
	 * @param json
	 *            传JSON数据
	 * @param key
	 *            传json中的字段
	 * @return 返回String类型的值
	 */
	public static String getString(String json, String key) {
		JSONObject jsonobject = JSONObject.fromObject(json);
		return jsonobject.getString(key);
	}

	/**
	 * 转JSON数组
	 * 
	 * @param json
	 *            传JSON数据
	 * @return
	 */
	public static JSONArray getJsonArray(String json) {
		JSONArray jsonArray = JSONArray.fromObject(json);
		return jsonArray;
	}

	/**
	 * JSON数组转String类型
	 * 
	 * @param json
	 *            传JSON数据
	 * @param key
	 *            传字段(key)取值
	 * @return
	 */
	public static String[] getArrayToStr(String json, String key) {
		JSONArray jsonArray = JSONArray.fromObject(json);
		String[] str = new String[(jsonArray.size())];
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonobject = jsonArray.getJSONObject(i);
			if (jsonobject != null) {
				str[i] = jsonobject.get(key).toString();
			}
		}
		return str;
	}
}
