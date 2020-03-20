package com.wanandroid.network;

import com.wanandroid.mvp.model.entity.BaseResponse;
import com.wanandroid.mvp.model.entity.UserInfo;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit service
 *
 * @author hengtao
 * @since 2019-10-25
 */
public class ApiService {
	private static final String BASE_URL = "https://www.wanandroid.com";

	private static final Retrofit sRetrofit = new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(RxJava3CallAdapterFactory.create())
			.build();

	private static final ApiRequest apiManager = sRetrofit.create(ApiRequest.class);

	public static Observable<BaseResponse<UserInfo>> login(String username, String password) {
		return apiManager.login(username, password);
	}

	public static Observable<BaseResponse<UserInfo>> register(String username, String password, String repassword) {
		return apiManager.register(username, password, repassword);
	}
}
