package com.wanandroid.ui.base;

import androidx.annotation.LayoutRes;

/**
 * @author hengtao
 * @since 2019-10-19
 */
public interface IActivityView {
	@LayoutRes
	int initView();
	void initData();
	void initStatusBar();
}
