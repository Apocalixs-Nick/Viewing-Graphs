package com.example.viewinggraphs

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SwitchChart {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Function to control the switch of chart
     */
    @Test//IT WORK
    fun switchCharts() {
        enableWifi(true)
        enableCellularData(true)
        Thread.sleep(3500)
        clickId(R.id.select1)
        Thread.sleep(3000)
        clickId(R.id.select2)
        Thread.sleep(3000)
        clickId(R.id.select3)
        Thread.sleep(1000)
    }
}