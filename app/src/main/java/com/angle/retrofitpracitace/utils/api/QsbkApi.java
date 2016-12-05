package com.angle.retrofitpracitace.utils.api;

import android.util.ArrayMap;

import com.angle.retrofitpracitace.beans.QsbkBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/12/5 0005.
 */

public interface QsbkApi {
    @GET("article/list/video")
    public Call<QsbkBean> getQsbk(@QueryMap ArrayMap<String,String> params);
}
