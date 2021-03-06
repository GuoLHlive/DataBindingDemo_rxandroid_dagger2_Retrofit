package com.example.administrator.servicedemo.util;

import com.example.administrator.servicedemo.config.BaiduApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/29.
 */
public class RetrofitUtil {
    private static Retrofit retrofit = null;
    public static Retrofit getnstance(){
        if (retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient();
            OkHttpClient.Builder builder = okHttpClient.newBuilder();
            builder.retryOnConnectionFailure(true);//重试连接
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BaiduApi.APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
