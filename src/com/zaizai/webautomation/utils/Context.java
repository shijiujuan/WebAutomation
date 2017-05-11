package com.zaizai.webautomation.utils;

public class Context {

	private static String browserType;
	private String byType;
	static Context context;

	public static Context getInstance() {
		if (context == null) {
			synchronized (Context.class) {
				if (context == null) {
					context = new Context();
				}
			}
		}
		return context;
	}

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		Context.browserType = browserType;
	}

	public String getByType() {
		return byType;
	}

	public void setByType(String byType) {
		this.byType = byType;
	}
}
