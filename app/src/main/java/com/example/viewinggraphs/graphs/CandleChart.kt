package com.example.viewinggraphs.graphs

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.util.TypedValue
import com.example.viewinggraphs.dataSet.CandleChartDataSet
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import java.util.*

class CandleChart(private val candleStickChart: CandleStickChart, private val context: Context) {

    var setData = CandleChartDataSet()

    fun createCandleChart() {
        val yVals = setData.setDataCandleChart()

        val set = CandleDataSet(yVals, "Random Candle Stick Data")
        //set.color = Color.rgb(80, 80, 80)
        set.shadowColor = Color.DKGRAY
        set.shadowWidth = 0.7f
        set.decreasingColor = Color.RED
        set.decreasingPaintStyle = Paint.Style.FILL
        set.increasingColor = Color.GREEN
        set.increasingPaintStyle = Paint.Style.FILL
        set.neutralColor = Color.BLUE
        set.valueTextSize = 16f
        set.setDrawValues(false)

        // Set description as false
        val descChartDescription = Description()
        descChartDescription.setEnabled(false)
        candleStickChart.setDescription(descChartDescription)
        //candleStickChart.description.isEnabled = false

        candleStickChart.moveViewToX(yVals.size - 15f)

        val data = CandleData(set)
        candleStickChart.data = data
        candleStickChart.invalidate()

        /*candleStickChart.xAxis.textSize = 20f
        candleStickChart.axisRight.textSize = 20f
        candleStickChart.axisLeft.textSize = 20f*/

        candleStickChart.animateXY(2000, 2000)

        /*candleStickChart.xAxis.textColor = getThemeTextColor(context)
        candleStickChart.axisRight.textColor = getThemeTextColor(context)
        candleStickChart.axisLeft.textColor = getThemeTextColor(context)
        set.valueTextColor = getThemeTextColor(context)*/

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
