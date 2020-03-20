package com.wanandroid.mvp.ui.activity.base;

import android.os.Bundle;

import com.wanandroid.R;
import com.wanandroid.mvp.ui.view.ToastUtil;
import com.wanandroid.util.WALog;
import com.wanandroid.util.ui.DialogUtil;
import com.wanandroid.util.ui.StatusBarUtil;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * base activity
 *
 * @author hengtao
 * @since 2019-10-19
 */
public abstract class BaseActivity extends SupportActivity implements IView, IActivity {
	private static final String TAG = "BaseActivity";

	@BindView(R.id.toolbar)
	protected Toolbar mToolbar;

	private Unbinder mUnbinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initLayoutId());
		mUnbinder = ButterKnife.bind(this);
		initView();
		initStatusBar();
		initData();
	}

	@Override
	public void initStatusBar() {
		WALog.logI(TAG, "this:" + this.getClass().getName());
		StatusBarUtil.setColor(this, getResources().getColor(R.color.colorMain));
//		StatusBarUtil.addStatusBarView(this, R.color.colorMain);
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
	public void showLoading() {
		WALog.logI(TAG, Thread.currentThread().getName() + " :showLoading");
		DialogUtil.showLoading(this);
	}

	@Override
	public void dismissLoading() {
		DialogUtil.dismissLoading();
	}

	@Override
	public void showMessage(String msg) {
		ToastUtil.getInstance().showShort(msg);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mUnbinder.unbind();
	}
}
