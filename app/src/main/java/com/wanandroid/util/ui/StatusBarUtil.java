package com.wanandroid.util.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.wanandroid.util.WALog;

import androidx.annotation.ColorInt;

/**
 * status bar tool
 *
 * @author hengtao
 * @since 2019-10-21
 */
public class StatusBarUtil {
	private static final String TAG = "StatusBarUtil";

	/**
	 * set status bar transparent
	 *
	 * @param context target context
	 */
	public static void setTransparent(Context context) {
		if (context instanceof Activity) {
			setTransparent(((Activity) context).getWindow());
		}
	}

	/**
	 * set status bar transparent
	 *
	 * @param window target window
	 */
	private static void setTransparent(Window window) {
		// 5.0及以上
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
			window.setStatusBarColor(Color.TRANSPARENT);
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {   //4.4到5.0
			WindowManager.LayoutParams localLayoutParams = window.getAttributes();
			localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
		}
	}

	/**
	 * set status bar color
	 *
	 * @param context target context
	 * @param color the color to be set
	 */
	public static void setColor(Context context, @ColorInt int color) {
		if (context instanceof Activity) {
			setColor(((Activity) context).getWindow(), color);
		}
	}

	/**
	 * set status bar color
	 *
	 * @param window target window
	 * @param color the color to be set
	 */
	private static void setColor(Window window, @ColorInt int color) {
		// 5.0及以上
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.setStatusBarColor(color);
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
	 * get height of status bar, the function can be used in onCreate(Activity) function
	 *
	 * @param context context to get system resource
	 * @return the height of status bar
	 */
	private static int getStatusBarHeight(Context context) {
		int height = 0;
		try {
			int resourceId = context.getResources().getIdentifier("status_bar_height",
					"dimen", "android");
			if (resourceId > 0) {
				height = context.getResources().getDimensionPixelSize(resourceId);
			}
		} catch (Exception e) {
			WALog.logE(TAG, "getStatusBarHeight error");
		}
		return height;
	}
}
