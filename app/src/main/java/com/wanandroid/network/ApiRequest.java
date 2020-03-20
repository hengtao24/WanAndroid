package com.wanandroid.network;

import com.wanandroid.mvp.model.entity.BaseResponse;
import com.wanandroid.mvp.model.entity.UserInfo;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * retrofit api request interface
 *
 * @author hengtao
 * @since 2019-10-28
 */
public interface ApiRequest {
	@FormUrlEncoded
	@POST("/user/login")
	Observable<BaseResponse<UserInfo>> login(@Field("username") String username, @Field("password") String password);

	@FormUrlEncoded
	@POST("/user/register")
	Observable<BaseResponse<UserInfo>> register(@Field("username") String username, @Field("password") String password,
	                                            @Field("repassword") String repassword);
 }
