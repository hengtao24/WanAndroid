package com.wanandroid.mvp.ui.activity;

import android.os.Bundle;

import com.wanandroid.R;
import com.wanandroid.mvp.ui.activity.base.BaseActivity;
import com.wanandroid.mvp.ui.activity.main.MainFragment;

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

	@Override
	public void initView() {
		super.initView();
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
	}

	@Override
	public void initData() {
		if (findFragment(MainFragment.class) == null) {
			loadRootFragment(R.id.main_framelayout, new MainFragment());
		}
	}
}
