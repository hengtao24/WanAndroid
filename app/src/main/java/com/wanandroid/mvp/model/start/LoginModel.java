package com.wanandroid.mvp.model.start;

import com.wanandroid.mvp.contract.start.LoginContract;
import com.wanandroid.mvp.model.entity.BaseResponse;
import com.wanandroid.mvp.model.entity.UserInfo;
import com.wanandroid.network.ApiService;

import io.reactivex.rxjava3.core.Observable;

/**
 * login model impl
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class LoginModel implements LoginContract.Model {
	private static final String TAG = "LoginModel";

	@Override
	public Observable<BaseResponse<UserInfo>> login(String username, String password) {
		return ApiService.login(username, password);
	}
}
