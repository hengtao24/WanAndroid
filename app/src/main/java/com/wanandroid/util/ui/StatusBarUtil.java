package com.wanandroid.util.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import com.wanandroid.util.WALog;

import androidx.annotation.ColorInt;

/**
 * @author hengtao
 * @since 2019-10-21
 */
public class StatusBarUtil {
	private static final String TAG = "StatusBarUtil";

	/**
	 * set status bar color
	 *
	 * @param activity target activity
	 * @param color the color to be set
	 */
	public static void setColor(Activity activity, @ColorInt int color){
		// 5.0及以上
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			View decorView = activity.getWindow().getDecorView();
			int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
			decorView.setSystemUiVisibility(option);
			activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
			WALog.logI(TAG, "Build.VERSION > LOLLIPOP");
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {   //4.4到5.0
			WindowManager.LayoutParams localLayoutParams = activity.getWindow().getAttributes();
			localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
		}
	}
}
