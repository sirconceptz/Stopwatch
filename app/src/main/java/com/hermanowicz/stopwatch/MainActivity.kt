/*
 * Copyright (c) 2019
 * Mateusz Hermanowicz - All rights reserved.
 * Stopwatch
 *
 * Licensed under GNU GENERAL PUBLIC LICENSE 3.0
 * Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 * The GNU General Public License is a free, copyleft license for
 * software and other kinds of works.
 */

package com.hermanowicz.stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var clockFragment: ClockFragment
    private lateinit var stopwatchFragment: StopwatchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clockFragment = ClockFragment()
        stopwatchFragment = StopwatchFragment()

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container, clockFragment,
                clockFragment.javaClass.simpleName
            )
            .add(
                R.id.fragment_container, stopwatchFragment,
                stopwatchFragment.javaClass.simpleName
            )
            .hide(stopwatchFragment)
            .commit()
        bottomNavView.setOnNavigationItemSelectedListener(navListener)
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.clock -> {
                supportFragmentManager.beginTransaction().hide(stopwatchFragment).show(clockFragment).commit()
                menuItem.isChecked = true
            }
            R.id.stopwatch -> {
                supportFragmentManager.beginTransaction().hide(clockFragment).show(stopwatchFragment).commit()
                menuItem.isChecked = true
            }
        }
        false
    }
}