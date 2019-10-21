package com.wanandroid.util;

import android.util.Log;

import java.util.List;

/**
 * @author hengtao
 * @since 2019-10-21
 */
public class WALog {
	private static boolean isEnableLog = true;

	/**
	 * 打开log观察调试信息
	 */
	public static void enableLog() {
		isEnableLog = true;
	}

	/**
	 * 打开log观察调试信息
	 */
	public static void disableLog() {
		isEnableLog = false;
	}

	/**
	 * @return 是否打开了log
	 */
	public static boolean isEnableLog() {
		return isEnableLog;
	}

	/**
	 * info级别log
	 *
	 * @param msg 消息
	 */
	public static void logI(String TAG,String msg) {
		if (isEnableLog) {
			Log.i(TAG, msg);
		}
	}

	/**
	 * verbose级别log
	 *
	 * @param msg 消息
	 */
	public static void logV(String TAG,String msg) {
		if (isEnableLog) {
			Log.v(TAG, msg);
		}
	}

	/**
	 * warning级别log
	 *
	 * @param msg 消息
	 */
	public static void logW(String TAG,String msg) {
		if (isEnableLog) {
			Log.w(TAG, msg);
		}
	}

	/**
	 * debug级别log
	 *
	 * @param msg 消息
	 */
	public static void logD(String TAG,String msg) {
		if (isEnableLog) {
			Log.d(TAG, msg);
		}
	}

	/**
	 * error级别log
	 *
	 * @param msg 消息
	 */
	public static void logE(String TAG,String msg) {
		if (isEnableLog) {
			Log.e(TAG, msg);
		}
	}

	/**
	 * error级别log
	 *
	 * @param msg 消息
	 */
	public static void logE(String TAG,String[] msg) {
		if (isEnableLog) {
			for (int i= 0; i<msg.length; i++){
				Log.e(TAG, msg[i]);
			}
		}
	}

	/**
	 * error级别log
	 *
	 * @param msg 消息
	 */
	public static void logE(String TAG,List<String> msg) {
		if (isEnableLog) {
			for (int i= 0; i<msg.size(); i++){
				Log.e(TAG, msg.get(i));
			}
		}
	}
}
