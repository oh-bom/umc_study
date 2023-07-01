package com.ohbom.retrofit_ex
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface hospitalService {
    @GET("/15077586/v1/centers")
    fun getHostpitalData(@Query("KEY")KEY:String,
                         @Query("TYPE")TYPE:String): Call<hospitalResponse>


}