package com.covid_tracker.ui.adapters
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.covid_tracker.repo.RemoteRepository
import com.covid_tracker.network.data.Country

/**
 * Created by Dhanshri on 17-06-2020.
 * dhanshri.pathrikar@gmail.com
 */
class MyViewModel : ViewModel() {

    fun callAPI() : MutableLiveData<Country>
    {
        return RemoteRepository().callAPI()
    }
}