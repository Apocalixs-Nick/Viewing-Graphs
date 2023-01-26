package com.example.viewinggraphs.pieTest

import android.content.Context
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.viewinggraphs.MainActivity
import com.example.viewinggraphs.R
import com.example.viewinggraphs.clickId
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
class PieChartTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Mock
    lateinit var pieChart: PieChart

    @Mock
    lateinit var context: Context

    lateinit var pie: com.example.viewinggraphs.graphs.PieChart

    val dataList: List<Int> = listOf(45, 35, 20)

    @Before
    fun setUp() {
        clickId(R.id.select2)
        MockitoAnnotations.initMocks(this)
        activity.getScenario().onActivity { activity ->
            context = activity
            pieChart = activity.findViewById(R.id.pie_graphic)
            pie = com.example.viewinggraphs.graphs.PieChart(pieChart, context, dataList)
        }
    }

    @Test
    fun testCreatePieChart() {
        pie.createPieChart()
        Assert.assertNotNull(pieChart)
    }
}
