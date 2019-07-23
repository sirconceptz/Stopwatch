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
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hermanowicz.stopwatch.databinding.FragmentStopwatchBinding
import kotlinx.android.synthetic.main.fragment_stopwatch.*

class StopwatchFragment : Fragment() {

    private lateinit var viewModel: StopwatchViewModel
    private lateinit var binding: FragmentStopwatchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(StopwatchViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stopwatch, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initObservers()
    }

    fun initObservers() {
        viewModel.chronometerRunning.observe(this, Observer<Boolean> { running ->
            if (running!!) {
                chronometer.base = SystemClock.elapsedRealtime() - viewModel.pauseOffset
                chronometer.start()
            } else {
                viewModel.pauseOffset = SystemClock.elapsedRealtime() - chronometer.base
                chronometer.stop()
            }
        })

        viewModel.mensuration.observe(this, Observer<Boolean> { mensuration ->
            if (mensuration!!)
                viewModel.addResult(chronometer.text.toString())
        })

        viewModel.results.observe(this, Observer<List<String>> { resultList ->
            when {
                resultList == null -> {
                    resultTV.text = ""
                    chronometer.base = SystemClock.elapsedRealtime()
                }
                resultList.size > 16 -> Toast.makeText(activity, getString(R.string.fullList), Toast.LENGTH_LONG).show()
                else -> resultTV.text = viewModel.convertResultsToShow(resultList)
            }
        })
    }
}