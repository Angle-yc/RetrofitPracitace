package com.angle.retrofitpracitace.utils;

import com.angle.retrofitpracitace.config.AppConfig;
import com.angle.retrofitpracitace.config.UrlConfig;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/12/5 0005.
 */

public class BaseRetrofit {
    private static Retrofit retrofit=null;
    private static BaseRetrofit baseRetrofit=null;

    public static Retrofit getRetrofit(){
        return retrofit;
    }

    public static void init(){
        if (baseRetrofit==null){
            baseRetrofit=new BaseRetrofit();
        }
    }

    private BaseRetrofit() {
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original=chain.request();
                HttpUrl httpUrl = original.url().newBuilder().build();
                Request request = original.newBuilder()
                        .addHeader("user-agent", "android")
                        .addHeader("Accept", "application/x-www-form-urlencoded")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                        .url(httpUrl)
                        .build();

                return chain.proceed(request);
            }
        }).connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false);



        OkHttpClient client=builder.build();
        retrofit=new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
