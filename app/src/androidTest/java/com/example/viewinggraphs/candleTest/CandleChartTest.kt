package com.example.viewinggraphs.candleTest

import android.content.Context
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.viewinggraphs.MainActivity
import com.example.viewinggraphs.R
import com.example.viewinggraphs.clickId
import com.example.viewinggraphs.graphs.CandleChart
import com.github.mikephil.charting.charts.CandleStickChart
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class CandleChartTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Mock
    lateinit var candleStickChart: CandleStickChart

    @Mock
    lateinit var context: Context

    lateinit var candleChart: CandleChart

    @Before
    fun setUp() {
        clickId(R.id.select3)
        MockitoAnnotations.initMocks(this)
        candleChart = CandleChart(candleStickChart, context)
    }

    @Test
    fun testCreateCandleChart() {
        candleChart.createCandleChart()
        Mockito.verify(candleStickChart).invalidate()
        /*Assert.assertFalse(candleStickChart.getDescription().isEnabled())
        Assert.assertNotNull(candleStickChart.getXAxis())
        Assert.assertNotNull(candleStickChart.getAxisRight())
        Assert.assertNotNull(candleStickChart.getAxisLeft())*/
    }
}

