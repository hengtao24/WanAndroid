package com.wanandroid.mvp.ui.activity;

import android.os.Bundle;

import com.wanandroid.R;
import com.wanandroid.mvp.presenter.start.LoginPresenter;
import com.wanandroid.mvp.ui.activity.base.BaseActivity;

/**
 * main activity
 *
 * @author hengtao
 * @since 2019-10-21
 */
public class MainActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public int initLayoutId() {
		return R.layout.activity_main;
	}
}
