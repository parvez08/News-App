package com.droid.smart_staff.newsapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.droid.smart_staff.newsapp.home.fragments.BlogsFragment
import com.droid.smart_staff.newsapp.home.fragments.NewsFragment
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(NewsFragment())
        setUpBottomNav()
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.flTopFrag.id, fragment)
        transaction.commit()
    }

    private fun setUpBottomNav() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bnv_news -> {
                    loadFragment(NewsFragment())
                    true
                }

                R.id.bnv_blogs -> {
                    loadFragment(BlogsFragment())
                    true
                }

                else -> {
                    loadFragment(NewsFragment())
                    true
                }
            }
        }
    }
}