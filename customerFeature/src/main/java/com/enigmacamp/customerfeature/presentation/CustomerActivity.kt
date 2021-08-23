package com.enigmacamp.customerfeature.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.core.presentation.ViewModelFactoryBase
import com.enigmacamp.customerfeature.databinding.ActivityCustomerBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CustomerActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityCustomerBinding

    @Inject
    lateinit var viewModel: CustomerActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        subscribe()
    }

    private fun subscribe() {
        viewModel.customerLiveData.observe(this, {
            binding.idCardTextView.text = it.idCard
            binding.nameTextView.text = it.name
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactoryBase {
            viewModel
        }).get(CustomerActivityViewModel::class.java)
    }
}