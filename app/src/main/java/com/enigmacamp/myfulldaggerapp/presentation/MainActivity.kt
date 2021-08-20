package com.enigmacamp.myfulldaggerapp.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldaggerapp.R
import com.enigmacamp.myfulldaggerapp.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        subscribe()
        binding.apply {
            loginButton.setOnClickListener {
                viewModel.customerLogin("jeco", "123")
            }
        }

    }

    private fun subscribe() {
        viewModel.isAuthenticated.observe(this, {
            if (it) {
                Log.d("Full-Dagger", "customerLogin: $it")
                startActivity(Intent(this, NextActivity::class.java))
                finish()
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactoryBase {
            viewModel
        }).get(MainActivityViewModel::class.java)
    }
}