package com.example.viewinggraphs.graphs

import android.content.Context
import com.example.viewinggraphs.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class BarChart(private val barChartView: BarChart, private val barContext: Context) {

    // Variable indicating graph
    lateinit var barChart: BarChart

    // Variable for data acquisition in the graph
    lateinit var barData: BarData

    // Variable for setting the data in the graph
    lateinit var barDataSet: BarDataSet

    // Variable for creating an Array list for bar data
    lateinit var barEntriesList: ArrayList<BarEntry>

    fun setBarChartData() {
        /*
        //x axis values

        val xvalue = ArrayList<String>()
        xvalue.add("Monday")
        xvalue.add("Tuesday")
        xvalue.add("Wednesday")
        xvalue.add("Thursday")
        xvalue.add("Saturday")
        xvalue.add("Sunday")

        //y axis values or bar data

        val barEntry = ArrayList<BarEntry>()
        barEntry.add(BarEntry(4f, 0f))
        barEntry.add(BarEntry(3.5f,1f))
        barEntry.add(BarEntry(8.9f,2f))
        barEntry.add(BarEntry(5.6f,3f))
        barEntry.add(BarEntry(2f,4f))
        barEntry.add(BarEntry(6f,5f))


        val barDataSet = BarDataSet(barEntry, "First")
        barDataSet.color = resources.getColor(R.color.black)

        val data = BarData(xvalue, barDataSet)
        binding.apply {
            graphic1.data = data
            graphic1.setBackgroundColor(resources.getColor(R.color.purple_200))
            graphic1.animateXY(3000, 3000)
        }*/

        // Graph acquisition
        barChart = barChartView.findViewById(R.id.bar_graphic)

        //Function call to add data to list of Arrays
        getBarChartData()

        // Adding data to the graph
        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")

        // Data initialization
        barData = BarData(barDataSet)

        //Setting the data in the graph
        barChart.data = barData

        // Setting bar color
        barDataSet.color = barContext.resources.getColor(R.color.purple_500)

        // Text size
        barDataSet.valueTextSize = 12f

        // Set description as false
        barChart.description.isEnabled = false

        barChart.animateXY(3000,3000)

    }

    /**
     * Private function to add data to the list of items in our bar
     */
    private fun getBarChartData() {
        barEntriesList = ArrayList()

        // Adding the data
        barEntriesList.add(BarEntry(1f, 1f))
        barEntriesList.add(BarEntry(2f, 2f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 4f))
        barEntriesList.add(BarEntry(5f, 5f))

    }
}