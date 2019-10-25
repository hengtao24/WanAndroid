package com.wanandroid.mvp.presenter.start;

import com.wanandroid.mvp.contract.start.LoginContract;
import com.wanandroid.mvp.model.start.LoginModel;
import com.wanandroid.mvp.presenter.BasePresenter;

/**
 * login presenter
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View>
		implements LoginContract.Presenter {
	@Override
	public void login(String username, String password) {

	}

	@Override
	public LoginContract.Model createModel() {
		return new LoginModel();
	}
}
