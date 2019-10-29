package com.wanandroid.mvp.contract.start;

import com.wanandroid.mvp.model.IBaseModel;
import com.wanandroid.mvp.model.entity.BaseResponse;
import com.wanandroid.mvp.model.entity.UserInfo;
import com.wanandroid.mvp.ui.activity.base.IBaseActivityView;

import io.reactivex.rxjava3.core.Observable;

/**
 * login contract
 *
 * @author hengtao
 * @since 2019-10-25
 */
public interface LoginContract {
	interface Model extends IBaseModel {
		Observable<BaseResponse<UserInfo>> login(String username, String password);
	}

	interface View extends IBaseActivityView {
		void onSuccess();
	}

	interface Presenter {
		void login(String username, String password);
	}
}
