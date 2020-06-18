package com.covid_tracker.network.data


/**
 * Created by Dhanshri on 17-06-2020.
 * dhanshri.pathrikar@gmail.com
 */
data class GlobalData(
        var Country: String,
        var NewConfirmed: Int,
        var TotalConfirmed: Int,
        var NewDeaths: Int,
        var TotalDeaths: Int,
        var NewRecovered: Int,
        var TotalRecovered: Int
)