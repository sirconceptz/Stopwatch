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

import android.app.Application
import android.content.Context
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class StopwatchViewModel(application: Application) : AndroidViewModel(application) {

    var context: Context = getApplication<Application>().applicationContext
    var buttonStartVisibility: ObservableInt = ObservableInt(View.VISIBLE)
    var buttonMensurationResetVisibility: ObservableInt = ObservableInt(View.GONE)
    var buttonResumePauseVisibility: ObservableInt = ObservableInt(View.GONE)
    var buttonMensurationResetText: ObservableInt = ObservableInt(R.string.mensuration)
    var buttonResumePauseText: ObservableInt = ObservableInt(R.string.pause)
    var chronometerRunning: MutableLiveData<Boolean> = MutableLiveData()
    var pauseOffset: Long = 0
    var results: MutableLiveData<List<String>> = MutableLiveData()
    var mensuration: MutableLiveData<Boolean> = MutableLiveData()

    fun onButtonStartClicked() {
        startChronometer()
    }

    fun onButtonMensurationResetClicked() {
        if (chronometerRunning.value == true)
            mensurationChronometer()
        else
            resetChronometer()
    }

    fun onButtonResumePauseClicked() {
        if (chronometerRunning.value == true)
            pauseChronometer()
        else
            startChronometer()
    }

    fun startChronometer() {
        chronometerRunning.value = true
        buttonStartVisibility.set(View.GONE)
        buttonMensurationResetVisibility.set(View.VISIBLE)
        buttonResumePauseVisibility.set(View.VISIBLE)
        buttonResumePauseText.set(R.string.pause)
        buttonMensurationResetText.set(R.string.mensuration)
    }

    fun mensurationChronometer() {
        if (results.value == null)
            results.value = mutableListOf("")
        mensuration.value = true
        mensuration.value = false
    }

    fun resetChronometer() {
        chronometerRunning.value = false
        pauseOffset = 0

        results.value = null
        buttonStartVisibility.set(View.VISIBLE)
        buttonMensurationResetVisibility.set(View.GONE)
        buttonResumePauseVisibility.set(View.GONE)
    }

    fun pauseChronometer() {
        chronometerRunning.value = false
        buttonResumePauseText.set(R.string.resume)
        buttonMensurationResetText.set(R.string.reset)
    }

    fun addResult(result: String) {
        var resultList: List<String>
        resultList = results.value!!
        resultList += "\n" + context.getString(R.string.time) + " " + results.value!!.size + ": " + result
        results.value = resultList
    }

    fun convertResultsToShow(result: List<String>): String {
        val resultString = result.toString().replace("[", "").replace("]", "").replace(",", "")
        return resultString
    }
}