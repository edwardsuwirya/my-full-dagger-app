package com.enigmacamp.myfulldaggerapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.enigmacamp.authenticationfeature.presentation.AuthenticationActivity
import com.enigmacamp.myfulldaggerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val intent = Intent(this,AuthenticationActivity::class.java)
        val intent = Intent()
        intent.setClassName(
            this,
            "com.enigmacamp.authenticationfeature.presentation.AuthenticationActivity"
        )
        startActivity(intent)
        finish()

    }


}