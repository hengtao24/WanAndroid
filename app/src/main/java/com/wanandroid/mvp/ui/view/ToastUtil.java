package com.wanandroid.mvp.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wanandroid.R;
import com.wanandroid.WAApp;

/**
 * toast util
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class ToastUtil {
	private static Toast mToast;

	/**
	 * show msg
	 *
	 * @param text the msg to show
	 */
	public static void show(String text) {
		if (mToast == null) {
			createToast(text);
		}
		mToast.cancel();
		mToast.show();
	}

	/**
	 * create toast
	 *
	 * @param text the msg to show
	 */
	private static void createToast(String text) {
		View view = LayoutInflater.from(WAApp.getAppContext()).inflate(R.layout.layout_toast, null);
		TextView textView = (TextView) view.findViewById(R.id.tv_toast);
		textView.setText(text);
		mToast = new Toast(WAApp.getAppContext());
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.setView(view);
	}
}
