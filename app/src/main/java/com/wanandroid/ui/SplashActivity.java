package com.wanandroid.ui;

import android.content.Intent;
import android.os.Bundle;

import com.wanandroid.R;
import com.wanandroid.ui.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author hengtao
 * @since 2019-10-12
 */
public class SplashActivity extends BaseActivity {
	Timer mTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int initLayoutId() {
		return R.layout.activity_splash;
	}

	@Override
	public void initView() {
	}

	@Override
	public void initData() {
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				goToMainActivity();
			}
		}, 1000);

	}

	private void goToMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
