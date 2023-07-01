package com.ohbom.retrofit_ex

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object retrofitApi {
    private const val BASE_URL="api.odcloud.kr/api"

    private val okHttpClient:OkHttpClient by lazy{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
                level=HttpLoggingInterceptor.Level.BODY
            })
            .build()

    }

    private val retrofit:Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())//json convertor
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    val hospitalservice:hospitalService by lazy {
        retrofit.create(hospitalService::class.java)
    }
}