package com.hermanowicz.stopwatch.DataModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hermanowicz.stopwatch.R
import com.hermanowicz.stopwatch.ViewModel.StopwatchViewModel


class StopwatchFragment : Fragment() {

    companion object {
        fun newInstance() = StopwatchFragment()
    }

    private lateinit var viewModel: StopwatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stopwatch, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StopwatchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
