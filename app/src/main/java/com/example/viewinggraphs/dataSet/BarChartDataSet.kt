package com.example.viewinggraphs.dataSet

import com.example.viewinggraphs.enums.BarChartListXY
import com.github.mikephil.charting.data.BarEntry

class BarChartDataSet {
    fun setDataBarChart(listXY: Array<BarChartListXY>, barEntriesList: ArrayList<BarEntry>) {
        for (i in 0 until listXY.size) {
            barEntriesList.add(BarEntry(listXY[i].x.toFloat(), listXY[i].y.toFloat()))
        }
    }
}