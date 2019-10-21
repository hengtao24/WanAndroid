package com.wanandroid.ui.base;

import android.os.Bundle;
import android.widget.Toolbar;

import com.wanandroid.R;
import com.wanandroid.util.ui.StatusBarUtil;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author hengtao
 * @since 2019-10-19
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivityView {
	protected Toolbar mToolbar;
	private Unbinder mUnbinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initView());
		mUnbinder = ButterKnife.bind(this);
		initStatusBar();
	}

	@Override
	public void initStatusBar() {
		StatusBarUtil.setColor(this, R.color.colorMain);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mUnbinder.unbind();
	}
}
