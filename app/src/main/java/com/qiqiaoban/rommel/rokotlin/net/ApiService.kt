package com.qiqiaoban.rommel.rokotlin.net

import com.qiqiaoban.rommel.rokotlin.bean.BaseDate
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import rx.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by 梁文硕 on 2017/5/18.
 */
class ApiService private constructor() {
    var apiManager: ApiManagerService
    val ENDPOINT:String = "http://ali-weather.showapi.com/"
    companion object {
        val getInstance by lazy(LazyThreadSafetyMode.NONE){
            ApiService()
        }
    }

    init {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(4, TimeUnit.SECONDS).build()
        val retrofit = Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiManager = retrofit.create(ApiManagerService::class.java)
    }


    interface ApiManagerService {

        @GET("http://ali-weather.showapi.com/hour24")
        fun getALiWeather(@Header("Authorization") APPCODE:String, @Query("area") area:String): Observable<BaseDate>
    }

}