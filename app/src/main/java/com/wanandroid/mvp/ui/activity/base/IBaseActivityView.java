package com.wanandroid.mvp.ui.activity.base;

import androidx.annotation.LayoutRes;

/**
 * base activity view(v of mvp) interface
 *
 * @author hengtao
 * @since 2019-10-19
 */
public interface IBaseActivityView {
	/**
	 * init layout xml id
	 *
	 * @return layout id
	 */
	@LayoutRes
	int initLayoutId();

	/**
	 * init view
	 */
	void initView();

	/**
	 * init data
	 */
	void initData();

	/**
	 * init status bar
	 */
	void initStatusBar();

	/**
	 * show loading view
	 */
	void showLoading();

	/**
	 * show message
	 *
	 * @param msg the msg to show
	 */
	void showMessage(String msg);
}
