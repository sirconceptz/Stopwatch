package com.hermanowicz.stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hermanowicz.stopwatch.DataModel.ClockFragment
import com.hermanowicz.stopwatch.DataModel.StopwatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container, ClockFragment(),
            ClockFragment().javaClass.simpleName
        ).commit()
        bottomNavView.setOnNavigationItemSelectedListener(navListener)
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.clock -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container, ClockFragment(),
                    ClockFragment().javaClass.simpleName
                ).commit()
            }
            R.id.stopwatch -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container, StopwatchFragment(),
                    StopwatchFragment().javaClass.simpleName
                ).commit()
            }
        }
        false
    }


}
