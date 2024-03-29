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

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.hermanowicz.stopwatch", appContext.packageName)
    }
}