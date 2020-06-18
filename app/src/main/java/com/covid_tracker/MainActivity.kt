package com.covid_tracker

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
//import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.covid_tracker.R
import com.covid_tracker.network.data.Country
import com.covid_tracker.ui.adapters.ModelListAdapter
import com.covid_tracker.ui.adapters.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.frag_home.recyclerview

class MainActivity : AppCompatActivity() {

    var mProgressBar: ProgressBar? = null

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        mProgressBar = progressBar
        progressBar.visibility = View.VISIBLE

        val data = Observer<Country> {
            recyclerview.adapter = ModelListAdapter(it.Countries)
            progressBar.visibility = View.GONE
        }

        viewModel.callAPI().observe(this,data)

    }
}