package com.zaizai.webautomation.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class EorrLog {

	public static void Log(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss");
		FileWriter fw = null;
		try {
			fw = new FileWriter(CreatUtils.creatFile(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(format.format(System.currentTimeMillis()) + ":" + str + "\r\n" + "\r\n");

			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
