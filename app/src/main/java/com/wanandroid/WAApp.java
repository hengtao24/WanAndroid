package com.wanandroid;

import android.app.Application;
import android.content.Context;

/**
 * application
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class WAApp extends Application {
	private static Context appContext = null;

	@Override
	public void onCreate() {
		super.onCreate();
		appContext = getApplicationContext();
	}

	public static synchronized Context getAppContext() {
		return appContext;
	}
}
