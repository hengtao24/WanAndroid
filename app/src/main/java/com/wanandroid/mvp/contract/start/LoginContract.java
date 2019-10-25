package com.wanandroid.mvp.contract.start;

import com.wanandroid.mvp.model.IBaseModel;
import com.wanandroid.mvp.ui.activity.base.IBaseActivityView;

/**
 * login contract
 *
 * @author hengtao
 * @since 2019-10-25
 */
public interface LoginContract {
	interface Model extends IBaseModel {
		void login();
	}

	interface View extends IBaseActivityView {
		void onSuccess();
	}

	interface Presenter {
		void login(String username, String password);
	}
}
