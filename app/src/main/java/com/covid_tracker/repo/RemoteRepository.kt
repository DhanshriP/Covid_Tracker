package com.covid_tracker.repo
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.covid_tracker.ui.adapters.interfaces.RetrofitApiService
import com.covid_tracker.network.data.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Dhanshri on 17-06-2020.
 * dhanshri.pathrikar@gmail.com
 */
class RemoteRepository {

    fun callAPI(): MutableLiveData<Country> {
        val mutableLiveData = MutableLiveData<Country>()

        RetrofitApiService().fetchData()
                .enqueue(object : Callback<Country> {
                    override fun onFailure(call: Call<Country>, t: Throwable) {
                        Log.d("Error", "Coudn't get the data")

                    }
                    override fun onResponse(call: Call<Country>, response: Response<Country>) {
                        if (response.isSuccessful) {
                            mutableLiveData.postValue(response.body())
                        } else {
                            Log.d("Error", "Coudn't get the data")
                        }
                    }
                })
        return mutableLiveData
    }
}