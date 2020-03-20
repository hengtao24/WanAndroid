package com.wanandroid.mvp.ui.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanandroid.mvp.presenter.BasePresenter;
import com.wanandroid.mvp.ui.view.ToastUtil;
import com.wanandroid.util.WALog;
import com.wanandroid.util.ui.DialogUtil;

import androidx.annotation.Nullable;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * base fragment
 *
 * @author hengtao
 * @since 2019-11-05
 */
public abstract class BaseFragment<P extends BasePresenter> extends SupportFragment implements IView, IFragment {
	private static final String TAG = "BaseFragment";

	private P mPresenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPresenter = createPresenter();
		if (mPresenter != null) {
			mPresenter.attachView(this);
		}
		WALog.logI(TAG, " onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		WALog.logI(TAG, " onCreateView");
		return initView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
		WALog.logI(TAG, " onActivityCreated");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (mPresenter != null) {
			mPresenter.detachView();
			mPresenter = null;
		}
	}

	protected abstract P createPresenter();

	@Override
	public void showLoading() {
		DialogUtil.showLoading(_mActivity);
	}

	@Override
	public void dismissLoading() {
		DialogUtil.dismissLoading();
	}

	@Override
	public void showMessage(String msg) {
		ToastUtil.getInstance().showShort(msg);
	}
}
