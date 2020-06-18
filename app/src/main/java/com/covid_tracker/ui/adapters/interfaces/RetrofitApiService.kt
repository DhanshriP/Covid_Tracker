package com.covid_tracker.ui.adapters.interfaces

import com.covid_tracker.network.data.Country
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.jvm.java


/**
 * Created by Dhanshri on 17-06-2020.
 * dhanshri.pathrikar@gmail.com
 */
interface RetrofitApiService {

    @GET("summary")
    fun fetchData(): Call<Country>

    companion object {
        operator fun invoke(): RetrofitApiService {
            return Retrofit.Builder()
                    .baseUrl("https://api.covid19api.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitApiService::class.java)
        }
    }
}