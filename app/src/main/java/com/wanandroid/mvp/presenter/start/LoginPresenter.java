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
					}

					@Override
					public void onNext(BaseResponse<UserInfo> userInfoBaseResponse) {
						WALog.logI(TAG, Thread.currentThread().getName() + " onNext");
						if (userInfoBaseResponse.isSuccess()) {
							getView().onSuccess(userInfoBaseResponse.getData());
						} else {
							getView().showMessage(userInfoBaseResponse.getErrorMsg());
						}
					}

					@Override
					public void onError(Throwable e) {
						String errMsg = e.getMessage();
						WALog.logE(TAG, errMsg);
						getView().dismissLoading();
						getView().showMessage(errMsg);
					}

					@Override
					public void onComplete() {
						getView().dismissLoading();
					}
				});
	}

	@Override
	public void register(String username, String password, String repassword) {
		getModel().register(username, password, repassword)
				.subscribeOn(Schedulers.io())
				.doOnSubscribe(o -> getView().showLoading())
				.observeOn(AndroidScheduler.mainThread())
				.subscribe(new Observer<BaseResponse<UserInfo>>() {
					@Override
					public void onSubscribe(Disposable d) {
					}

					@Override
					public void onNext(BaseResponse<UserInfo> userInfoBaseResponse) {
						WALog.logI(TAG, Thread.currentThread().getName() + " onNext");
						if (userInfoBaseResponse.isSuccess()) {
							getView().onSuccess(userInfoBaseResponse.getData());
						} else {
							getView().showMessage(userInfoBaseResponse.getErrorMsg());
						}
					}

					@Override
					public void onError(Throwable e) {
						String errMsg = e.getMessage();
						WALog.logE(TAG, errMsg);
						getView().dismissLoading();
						getView().showMessage(errMsg);
					}

					@Override
					public void onComplete() {
						getView().dismissLoading();
					}
				});
	}

	@Override
	public LoginContract.Model createModel() {
		return new LoginModel();
	}
}
