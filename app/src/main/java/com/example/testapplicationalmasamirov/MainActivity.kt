package com.example.testapplicationalmasamirov

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider


import com.example.testapplicationalmasamirov.viewmodel.Factory
import com.example.testapplicationalmasamirov.viewmodel.ViewModel

lateinit var viewModel: ViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(R.layout.activity_main)

        val factory =
            Factory(
                application
            )
        viewModel = ViewModelProvider(this, factory).get(
            ViewModel::class.java)
    }
}