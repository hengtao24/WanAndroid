package com.wanandroid.mvp.model.entity;

/**
 * base response
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class BaseResponse<T> {
	private T data;

	private int errorCode;

	private String errorMsg;

	public boolean isSuccess() {
		return errorCode == 0;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
