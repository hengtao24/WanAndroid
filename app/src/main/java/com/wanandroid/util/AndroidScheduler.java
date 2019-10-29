package com.wanandroid.util;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * main thread scheduler
 *
 * @author hengtao
 * @since 2019-10-29
 */
public class AndroidScheduler implements Executor {
	private static AndroidScheduler sAndroidScheduler;

	private final Handler mHandler;

	private final Scheduler mScheduler;

	private AndroidScheduler() {
		mHandler = new Handler(Looper.getMainLooper());
		mScheduler = Schedulers.from(this);
	}

	@Override
	public void execute(Runnable command){
		mHandler.post(command);
	}

	public static synchronized Scheduler mainThread() {
		if (sAndroidScheduler == null) {
			sAndroidScheduler = new AndroidScheduler();
		}
		return sAndroidScheduler.mScheduler;
	}
}
