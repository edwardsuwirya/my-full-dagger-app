package com.enigmacamp.myfulldaggerapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.myfulldaggerapp.R
import com.enigmacamp.myfulldaggerapp.data.SharedPref
import com.enigmacamp.myfulldaggerapp.data.api.RetrofitInstance
import com.enigmacamp.myfulldaggerapp.data.db.AppDatabase
import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepository
import com.enigmacamp.myfulldaggerapp.data.repository.AuthenticationRepositoryImpl
import com.enigmacamp.myfulldaggerapp.data.repository.CustomerRepositoryImpl
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        viewModel.customerLogin("jeco", "123")
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val sharedPref = SharedPref(applicationContext)
                val authenticationRepository =
                    AuthenticationRepositoryImpl(
                        RetrofitInstance(sharedPref).authApi,
                        sharedPref
                    )
                val db = AppDatabase.getDatabase(applicationContext)
                val customerRepository = CustomerRepositoryImpl(db)
                return MainActivityViewModel(
                    authenticationRepository,
                    customerRepository
                ) as T
            }

        }).get(MainActivityViewModel::class.java)
    }
}