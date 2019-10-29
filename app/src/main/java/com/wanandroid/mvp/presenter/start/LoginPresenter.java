package com.wanandroid.mvp.presenter.start;

import com.wanandroid.mvp.contract.start.LoginContract;
import com.wanandroid.mvp.model.entity.BaseResponse;
import com.wanandroid.mvp.model.entity.UserInfo;
import com.wanandroid.mvp.model.start.LoginModel;
import com.wanandroid.mvp.presenter.BasePresenter;
import com.wanandroid.network.ApiService;
import com.wanandroid.util.AndroidScheduler;
import com.wanandroid.util.WALog;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * login presenter
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View>
		implements LoginContract.Presenter {
	private static final String TAG = "LoginPresenter";

	@Override
	public void login(String username, String password) {
		getModel().login(username, password)
				.subscribeOn(Schedulers.io())
				.doOnSubscribe(o -> getView().showLoading())
				.observeOn(AndroidScheduler.mainThread())
				.subscribe(new Observer<BaseResponse<UserInfo>>() {
					@Override
					public void onSubscribe(Disposable d) {
						WALog.logI(TAG, Thread.currentThread().getName() + " onSubscribe");
					}

					@Override
					public void onNext(BaseResponse<UserInfo> userInfoBaseResponse) {
						WALog.logI(TAG, userInfoBaseResponse.getData().toString());
						WALog.logI(TAG, Thread.currentThread().getName() + " onNext");
					}

					@Override
					public void onError(Throwable e) {
						
					}

					@Override
					public void onComplete() {

					}
				});
	}

	@Override
	public LoginContract.Model createModel() {
		return new LoginModel();
	}
}
