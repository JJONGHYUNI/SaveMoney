package com.example.savemoney.presentation.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.savemoney.R
import com.example.savemoney.databinding.ActivityMainBinding
import com.example.savemoney.presentation.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //페이저 어댑터 연결
        binding.pager.adapter=ViewPagerAdapter(this)
        binding.pager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bottomNavigation.menu.getItem(position).isChecked = true
                }
            }
        )
        binding.bottomNavigation.setOnItemSelectedListener{navigationSelected(it)}
    }
    private fun navigationSelected(item: MenuItem): Boolean {
        val checked = item.setChecked(true)
        when (checked.itemId) {
            R.id.menu_home -> {
                binding.pager.currentItem = 0
                return true
            }
            R.id.menu_calendar -> {
                binding.pager.currentItem = 1
                return true
            }
            R.id.menu_mypage -> {
                binding.pager.currentItem = 2
                return true
            }
        }
        return false
    }
}

