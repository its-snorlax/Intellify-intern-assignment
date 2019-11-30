package com.assignment.intellify.network;

import com.assignment.intellify.ApiParam;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    public static <T> T build(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiParam.BASE_URL)
                .client(new OkHttpClient().newBuilder().cookieJar(new TokenCookieJar()).build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

}
