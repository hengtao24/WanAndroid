package com.wanandroid.mvp.ui.activity.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanandroid.R;
import com.wanandroid.mvp.presenter.main.MainPresenter;
import com.wanandroid.mvp.ui.activity.base.BaseFragment;

/**
 * desc
 *
 * @author hengtao
 * @since 2019-11-13
 */
public class HomeFragment extends BaseFragment {
	@Override
	public int initLayoutId() {
		return R.layout.fragment_main;
	}

	@Override
	public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(initLayoutId(), container, false);
	}

	@Override
	public void initData(Bundle savedInstanceState){
	}

	@Override
	protected MainPresenter createPresenter() {
		return new MainPresenter();
	}
}
