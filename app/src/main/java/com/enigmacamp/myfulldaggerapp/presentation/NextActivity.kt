package com.enigmacamp.myfulldaggerapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldaggerapp.databinding.ActivityNextBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NextActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityNextBinding

    @Inject
    lateinit var viewModel: NextActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
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
        }).get(NextActivityViewModel::class.java)
    }
}