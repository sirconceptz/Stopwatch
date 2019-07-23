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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ClockFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_clock, container, false)
    }
}