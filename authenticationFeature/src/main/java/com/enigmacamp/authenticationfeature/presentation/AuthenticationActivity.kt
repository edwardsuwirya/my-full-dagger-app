package com.enigmacamp.authenticationfeature.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.authenticationfeature.databinding.ActivityAuthenticationBinding
import com.enigmacamp.core.presentation.ViewModelFactoryBase
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthenticationActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding

    @Inject
    lateinit var viewModel: AuthenticationActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
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
//                startActivity(Intent(this, CustomerActivity::class.java))
//                finish()
                val intent = Intent()
                intent.setClassName(
                    this,
                    "com.enigmacamp.customerfeature.presentation.CustomerActivity"
                )
                startActivity(intent)
                finish()
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactoryBase {
            viewModel
        }).get(AuthenticationActivityViewModel::class.java)
    }
}