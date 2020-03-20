package com.wanandroid.mvp.ui.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

/**
 * fragment base interface
 *
 * @author hengtao
 * @since 2019-11-06
 */
public interface IFragment {
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
	View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

	/**
	 * init data
	 */
	void initData(@NonNull Bundle savedInstanceState);
}
