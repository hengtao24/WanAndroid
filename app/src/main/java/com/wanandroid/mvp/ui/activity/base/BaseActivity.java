package com.wanandroid.mvp.ui.activity.base;

import android.os.Bundle;

import com.wanandroid.R;
import com.wanandroid.mvp.presenter.BasePresenter;
import com.wanandroid.mvp.ui.view.ToastUtil;
import com.wanandroid.util.WALog;
import com.wanandroid.util.ui.StatusBarUtil;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * base activity
 *
 * @author hengtao
 * @since 2019-10-19
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseActivityView {
	private static final String TAG = "BaseActivity";

	@BindView(R.id.toolbar)
	protected Toolbar mToolbar;

	private Unbinder mUnbinder;

	protected P mPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(initLayoutId());
		mUnbinder = ButterKnife.bind(this);
		initView();
		initStatusBar();
		initData();
		mPresenter = createPresenter();
		if (mPresenter != null) {
			mPresenter.attachView(this);
		}
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
	}

	@Override
	public void showMessage(String msg) {
		ToastUtil.show(msg);
	}

	protected abstract P createPresenter();

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mUnbinder.unbind();
		if (mPresenter != null) {
			mPresenter.detachView();
			mPresenter = null;
		}
	}
}
