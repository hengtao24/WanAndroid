package com.wanandroid.mvp.ui.activity.base;

import androidx.annotation.LayoutRes;

/**
 * activity interface
 *
 * @author hengtao
 * @since 2019-11-06
 */
public interface IActivity {
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
}
