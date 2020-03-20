package com.wanandroid.mvp.ui.activity.base;

/**
 * base view(v of mvp) interface
 *
 * @author hengtao
 * @since 2019-10-19
 */
public interface IView {
	/**
	 * show loading view
	 */
	void showLoading();

	/**
	 * dismiss loading view
	 */
	void dismissLoading();

	/**
	 * show message
	 *
	 * @param msg the msg to show
	 */
	void showMessage(String msg);
}
