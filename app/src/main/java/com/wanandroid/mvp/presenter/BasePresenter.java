package com.wanandroid.mvp.presenter;

import com.wanandroid.mvp.model.IBaseModel;
import com.wanandroid.mvp.ui.activity.base.IBaseActivityView;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * base presenter (p of mvp) class
 *
 * @author hengtao
 * @since 2019-10-24
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseActivityView> {
	// proxy view
	private V mProxyView;

	// model
	private M mModel;

	// WeakReference
	private WeakReference<V> mWeakReference;

	/**
	 * attach view, for monitoring the view life cycle
	 *
	 * @param view the view to attach,
	 */
	@SuppressWarnings("unchecked")
	public void attachView(V view) {
		mWeakReference = new WeakReference<V>(view);
		mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(),
				view.getClass().getInterfaces(), new MvpViewProxy(mWeakReference.get()));
		if (mModel == null) {
			mModel = createModel();
		}
	}

	/**
	 * detach view when the view is destory
	 */
	public void detachView() {
		mModel = null;
		if (isAttachedView()) {
			mWeakReference.clear();
			mWeakReference = null;
		}
	}

	/**
	 * is view attached
	 *
	 * @return true:view is attached
	 */
	protected boolean isAttachedView() {
		return mWeakReference != null && mWeakReference.get() != null;
	}

	protected V getView() {
		return mProxyView;
	}

	protected M getModel() {
		return mModel;
	}

	protected abstract M createModel();

	/**
	 * mvp view proxy class
	 */
	private class MvpViewProxy implements InvocationHandler {
		private IBaseActivityView iBaseActivityView;

		MvpViewProxy(IBaseActivityView baseActivityView) {
			iBaseActivityView = baseActivityView;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (isAttachedView()) {
				return method.invoke(iBaseActivityView, args);
			}
			return null;
		}
	}
}
