package com.enigmacamp.myfulldaggerapp.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldaggerapp.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        viewModel.customerLogin("jeco", "123")
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactoryBase {
            viewModel
        }).get(MainActivityViewModel::class.java)
    }
}