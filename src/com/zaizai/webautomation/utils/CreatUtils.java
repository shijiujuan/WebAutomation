package com.zaizai.webautomation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class CreatUtils {
	
	private static String config = System.getProperty("user.dir");
	private static long currentTimeMillis = System.currentTimeMillis();
	
	// 生成文件
	public static File creatFile() {		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String file = "log" + format.format(currentTimeMillis) + ".txt";
		File f = new File(config, file);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				EorrLog.Log("生成文件报错。" + e.toString());
			}
		}
		return f;
	}
}
