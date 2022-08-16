package com.example.savemoney.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.savemoney.presentation.screens.calendar.CalendarFragment
import com.example.savemoney.presentation.screens.home.HomeFragment
import com.example.savemoney.presentation.screens.mypage.MyPageFragment

class ViewPagerAdapter (fragment:FragmentActivity):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int =3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CalendarFragment()
            2 -> MyPageFragment()
            else -> error("No Fragment")
        }
    }

}