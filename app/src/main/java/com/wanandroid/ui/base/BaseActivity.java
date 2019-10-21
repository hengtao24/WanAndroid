package com.wanandroid.ui.base;

import android.os.Bundle;

import com.wanandroid.R;
import com.wanandroid.util.ui.StatusBarUtil;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author hengtao
 * @since 2019-10-19
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivityView {
	@BindView(R.id.toolbar)
	protected Toolbar mToolbar;
	private Unbinder mUnbinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initLayoutId());
		mUnbinder = ButterKnife.bind(this);
		initStatusBar();
		initView();
		initData();
	}

	@Override
	public void initStatusBar() {
		StatusBarUtil.setTransparent(this);
		StatusBarUtil.addStatusBarView(this, R.color.colorMain);
	}

	@Override
	public void initView() {
		if (mToolbar != null) {
			setSupportActionBar(mToolbar);
		}
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setDisplayShowTitleEnabled(false);
		}
	}

	@Override
	public void initData() {
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mUnbinder.unbind();
	}
}
