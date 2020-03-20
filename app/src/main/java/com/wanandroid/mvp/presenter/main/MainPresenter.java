package com.wanandroid.mvp.presenter.main;

import com.wanandroid.mvp.contract.main.MainContract;
import com.wanandroid.mvp.model.main.MainModel;
import com.wanandroid.mvp.presenter.BasePresenter;

/**
 * main presenter
 *
 * @author hengtao
 * @since 2019-11-05
 */
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View>
		implements MainContract.Presenter {

	@Override
	public MainContract.Model createModel() {
		return new MainModel();
	}
}
