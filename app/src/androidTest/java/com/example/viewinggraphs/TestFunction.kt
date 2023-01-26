package com.example.viewinggraphs

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry

/**
 * Function that takes a boolean value as input to enable and disable wifi
 * via a shell command through the uiAutomation object
 */
fun enableWifi(enable: Boolean){
    when (enable)
    {
        true -> InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("svc wifi enable")
        false -> InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("svc wifi disable")
    }
}

/**
 * Function that takes a boolean value as input to enable and disable cellular data
 * via a shell command through the uiAutomation object
 */
fun enableCellularData(enable: Boolean){
    when (enable)
    {
        true -> InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("svc data enable")
        false -> InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand("svc data disable")
    }
}

fun clickId(idInput: Int){
    Espresso.onView(ViewMatchers.withId(idInput))
        .perform(ViewActions.click())
}

