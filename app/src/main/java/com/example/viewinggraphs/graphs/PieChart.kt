package com.example.viewinggraphs.graphs

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import com.example.viewinggraphs.R
import com.example.viewinggraphs.dataSet.PieChartDataSet
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF

class PieChart(private val pieChartView: PieChart, private val pieContext: Context, dataList: List<Int>) {
    // Variable indicating graph
    lateinit var pieChart: PieChart

    // Variable for data acquisition in the graph
    lateinit var pieData: PieData

    // Variable for setting the data in the graph
    lateinit var pieDataSet: PieDataSet

    // Variable for creating an Array list for bar data
    lateinit var pieEntriesList: ArrayList<PieEntry>

    var setData = PieChartDataSet(dataList)

    fun createPieChart() {

        // on below line we are initializing our
        // variable with their ids.
        pieChart = pieChartView.findViewById(R.id.pie_graphic)

        // on below line we are setting user percent value,
        // setting description as enabled and offset for pie chart
        pieChart.setUsePercentValues(true)
        pieChart.getDescription().setEnabled(false)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)

        // on below line we are setting drag for our pie chart
        pieChart.setDragDecelerationFrictionCoef(0.95f)

        // on below line we are setting hole
        // and hole color for pie chart
        pieChart.setDrawHoleEnabled(false)
        pieChart.setHoleColor(Color.WHITE)

        // on below line we are setting circle color and alpha
        pieChart.setTransparentCircleColor(Color.WHITE)
        pieChart.setTransparentCircleAlpha(110)

        // on  below line we are setting hole radius
        pieChart.setHoleRadius(58f)
        pieChart.setTransparentCircleRadius(61f)

        // on below line we are setting center text
        pieChart.setDrawCenterText(true)

        // on below line we are setting
        // rotation for our pie chart
        pieChart.setRotationAngle(0f)

        // enable rotation of the pieChart by touch
        pieChart.setRotationEnabled(true)
        pieChart.setHighlightPerTapEnabled(true)

        // on below line we are setting animation for our pie chart
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        // on below line we are disabling our legend for pie chart
        pieChart.legend.isEnabled = false
        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.setEntryLabelTextSize(16f)

        // on below line we are creating array list and
        // adding data to it to display in pie chart
        var entries: ArrayList<PieEntry> = ArrayList()
        /*entries.add(PieEntry(45f))
        entries.add(PieEntry(10f))
        entries.add(PieEntry(5f))
        entries.add(PieEntry(15f))
        entries.add(PieEntry(5f))*/

        entries = setData.setDataPieChart()

        // on below line we are setting pie data set
        val dataSet = PieDataSet(entries, "Mobile OS")

        // on below line we are setting icons.
        dataSet.setDrawIcons(false)

        // on below line we are setting slice for pie
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        // add a lot of colors to list
        val colors: ArrayList<Int> = ArrayList()
        colors.add(pieContext.resources.getColor(R.color.red))
        colors.add(pieContext.resources.getColor(R.color.green))
        colors.add(pieContext.resources.getColor(R.color.blue))
        colors.add(pieContext.resources.getColor(R.color.sky_blue))
        colors.add(pieContext.resources.getColor(R.color.yellow))
        colors.add(pieContext.resources.getColor(R.color.pink))

        // on below line we are setting colors.
        dataSet.colors = colors

        // on below line we are setting pie data set
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(15f)
        data.setValueTypeface(Typeface.DEFAULT_BOLD)
        data.setValueTextColor(Color.WHITE)
        pieChart.setData(data)

        // undo all highlights
        pieChart.highlightValues(null)

        pieChart.animateXY(2000,2000)

        // loading chart
        pieChart.invalidate()

    }
}