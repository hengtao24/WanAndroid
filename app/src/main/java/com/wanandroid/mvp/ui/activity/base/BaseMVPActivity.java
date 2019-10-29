package com.wanandroid.mvp.ui.activity.base;

import android.os.Bundle;

import com.wanandroid.mvp.presenter.BasePresenter;

/**
 * base mvp activity
 *
 * @author hengtao
 * @since 2019-10-28
 */
public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity {
	protected P mPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPresenter = createPresenter();
		if (mPresenter != null) {
			mPresenter.attachView(this);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mPresenter != null) {
			mPresenter.detachView();
			mPresenter = null;
		}
	}

	protected abstract P createPresenter();
}
