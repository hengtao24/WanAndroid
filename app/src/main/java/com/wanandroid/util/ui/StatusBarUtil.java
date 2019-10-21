package com.wanandroid.util.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.wanandroid.util.WALog;

import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;

/**
 * @author hengtao
 * @since 2019-10-21
 */
public class StatusBarUtil {
	private static final String TAG = "StatusBarUtil";

	/**
	 * set status bar transparent
	 *
	 * @param activity target activity
	 */
	public static void setTransparent(Activity activity) {
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

	/**
	 * add status bar view
	 *
	 * @param activity target activity
	 * @param color the color to be fill
	 */
	public static void addStatusBarView(Activity activity, @ColorInt int color) {
		View view = new View(activity);
		view.setBackgroundColor(color);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
		ViewGroup decorView = (ViewGroup) activity.findViewById(android.R.id.content);
		decorView.addView(view, params);
	}

	/**
	 * get height of status bar
	 *
	 * @param activity target acticity
	 * @return int the height of status bar
	 */
	private static int getStatusBarHeight(Activity activity) {
		Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		WALog.logI(TAG, "StatusBarHeight:" + rect.top);
		return rect.top;
	}
}
