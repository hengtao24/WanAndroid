package com.wanandroid.util.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

import com.wanandroid.util.Constants;

/**
 * dialog util
 *
 * @author hengtao
 * @since 2019-10-30
 */
public class DialogUtil {
	private static volatile ProgressDialog sProgressDialog;

	private DialogUtil() {
	}

	/**
	 * show progress dialog
	 */
	public static void showLoading(Context context) {
		if (sProgressDialog != null) {
			if (sProgressDialog.isShowing()) {
				return;
			}
		} else {
			initInstance(context);
		}
		sProgressDialog.show();
	}

	/**
	 * dismiss progress dialog
	 */
	public static void dismissLoading() {
		if (sProgressDialog.isShowing()) {
			sProgressDialog.dismiss();
		}
	}

	/**
	 * get progress dialog single instance
	 *
	 * @param context context to init progress dialog
	 */
	private static void initInstance(Context context) {
		if (sProgressDialog == null) {
			synchronized (DialogUtil.class) {
				if (sProgressDialog == null) {
					sProgressDialog = new ProgressDialog(context);
					sProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					sProgressDialog.setCanceledOnTouchOutside(false);
					sProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					sProgressDialog.setMessage(Constants.REQUEST_NETWORK);
				}
			}
		}
	}
}
