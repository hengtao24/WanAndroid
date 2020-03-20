package com.wanandroid.mvp.ui.view;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wanandroid.R;
import com.wanandroid.WAApp;
import com.wanandroid.util.WALog;

/**
 * toast util
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class ToastUtil {
	private static final String TAG = "ToastUtil";

	private static volatile ToastUtil sToastUtil = null;

	private Toast mToast;

	private View mView;

	private TextView mTextView;

	private Handler mHandler = new Handler(Looper.getMainLooper());

	public static ToastUtil getInstance() {
		if (sToastUtil == null) {
			synchronized (ToastUtil.class) {
				if (sToastUtil == null) {
					sToastUtil = new ToastUtil();
				}
			}
		}
		return sToastUtil;
	}

	/**
	 * show msg short
	 *
	 * @param text the msg to show
	 */
	public void showShort(String text) {
		if (TextUtils.isEmpty(text)) {
			WALog.logE(TAG, "no show msg");
			return;
		}

		mHandler.post(new Runnable() {
			@Override
			public void run() {
				if (mToast == null) {
					createToast(text);
				}
				mTextView.setText(text);
				mToast.setDuration(Toast.LENGTH_SHORT);
				mToast.show();
			}
		});


	}

	/**
	 * show msg long
	 *
	 * @param text the msg to show
	 */
	public void showLong(String text) {
		if (TextUtils.isEmpty(text)) {
			WALog.logE(TAG, "no show msg");
			return;
		}

		mHandler.post(new Runnable() {
			@Override
			public void run() {
				if (mToast == null) {
					createToast(text);
				}
				mTextView.setText(text);
				mToast.setDuration(Toast.LENGTH_LONG);
				mToast.show();
			}
		});
	}

	/**
	 * create toast
	 *
	 * @param text the msg to show
	 */
	private synchronized void createToast(String text) {
		mView = LayoutInflater.from(WAApp.getAppContext()).inflate(R.layout.layout_toast, null);
		mTextView = mView.findViewById(R.id.tv_toast);
		mTextView.setText(text);
		mToast = new Toast(WAApp.getAppContext());
		mToast.setView(mView);
	}
}
