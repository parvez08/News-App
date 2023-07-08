package com.droid.smart_staff.newsapp.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.droid.smart_staff.newsapp.home.HomeActivity
import com.example.newsapp.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        goToHomeScreen()
    }

    private fun goToHomeScreen() {
        handler.postDelayed({
            val homeIntent = Intent(this@SplashScreenActivity, HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        }, 3000)
    }
}