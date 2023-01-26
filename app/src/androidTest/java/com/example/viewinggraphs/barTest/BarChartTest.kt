package com.example.viewinggraphs.barTest

import android.content.Context
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.viewinggraphs.MainActivity
import com.example.viewinggraphs.R
import com.example.viewinggraphs.clickId
import com.example.viewinggraphs.enums.BarChartListXY
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class BarChartTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Mock
    lateinit var barChart: BarChart

    @Mock
    lateinit var context: Context

    lateinit var bar: com.example.viewinggraphs.graphs.BarChart

    val listXY = BarChartListXY.values()

    @Before
    fun setUp() {
        //clickId(R.id.select1)
        MockitoAnnotations.initMocks(this)
        activity.getScenario().onActivity { activity ->
            context = activity
            barChart = activity.findViewById(R.id.bar_graphic)
            bar = com.example.viewinggraphs.graphs.BarChart(barChart, context)
        }
    }

    @Test
    fun testCreateBarChart() {
        bar.createBarChart(listXY)
        Assert.assertNotNull(barChart)
    }
}
