package com.example.viewinggraphs.graphs

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import androidx.core.graphics.toColorInt
import com.example.viewinggraphs.R
import com.example.viewinggraphs.dataSet.BarChartDataSet
import com.example.viewinggraphs.enums.BarChartListXY
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlin.collections.ArrayList

class BarChart(private val barChartView: BarChart, private val barContext: Context) {

    // Variable indicating graph
    lateinit var barChart: BarChart

    // Variable for data acquisition in the graph
    lateinit var barData: BarData

    // Variable for setting the data in the graph
    lateinit var barDataSet: BarDataSet

    // Variable for creating an Array list for bar data
    lateinit var barEntriesList: ArrayList<BarEntry>

    var setData = BarChartDataSet()

    fun createBarChart(listXY: Array<BarChartListXY>) {

        // Graph acquisition
        barChart = barChartView.findViewById(R.id.bar_graphic)

        //Function call to add data to list of Arrays
        getBarChartData(listXY = listXY)

        // Adding data to the graph
        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")

        // Data initialization
        barData = BarData(barDataSet)

        //Setting the data in the graph
        barChart.data = barData

        // Setting bar color
        //barDataSet.color = barContext.resources.getColor(R.color.purple_500)
        // Setting bar color
        var i = 0
        for (barEntry in barEntriesList) {
            //barDataSet.color = barContext.resources.getColor(list[i].colorCode)
            // add a lot of colors to list
            val colors: ArrayList<Int> = ArrayList()
            colors.add(barContext.resources.getColor(R.color.red))
            colors.add(barContext.resources.getColor(R.color.blue))
            colors.add(barContext.resources.getColor(R.color.sky_blue))
            colors.add(barContext.resources.getColor(R.color.green))
            colors.add(barContext.resources.getColor(R.color.pink))
            colors.add(barContext.resources.getColor(R.color.yellow))
            // on below line we are setting colors.
            barDataSet.colors = colors
            i++
        }

        // Text size
        barDataSet.valueTextSize = 16f
        barDataSet.valueTextColor = getThemeTextColor(barContext)

        //barDataSet.valueTextColor = barContext.resources.getColor(R.color.teal_200)

        // Set description as false
        barChart.description.isEnabled = false

        //barChart.animateXY(3000, 3000)

        barChart.xAxis.textSize = 20f
        barChart.axisRight.textSize = 20f
        barChart.axisLeft.textSize = 20f

        barChart.xAxis.textColor = getThemeTextColor(barContext)
        barChart.axisRight.textColor = getThemeTextColor(barContext)
        barChart.axisLeft.textColor = getThemeTextColor(barContext)
    }

    /**
     * Private function to add data to the list of items in our bar
     */
    private fun getBarChartData(listXY: Array<BarChartListXY>) {
        barEntriesList = ArrayList()

        // Adding the data
        setData.setDataBarChart(listXY, barEntriesList)
    }

    open fun getThemeTextColor(context: Context): Int {
        val typedValue = TypedValue()
        val theme: Resources.Theme = context.theme
        theme.resolveAttribute(
            com.google.android.material.R.attr.colorOnBackground,
            typedValue,
            true
        )
        return typedValue.data
    }
}