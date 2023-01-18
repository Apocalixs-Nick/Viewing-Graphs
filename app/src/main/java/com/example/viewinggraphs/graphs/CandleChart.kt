package com.example.viewinggraphs.graphs

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import java.util.*
import kotlin.collections.ArrayList

class CandleChart(private val candleStickChart: CandleStickChart, private val context: Context) {

    fun setCandleChartData() {
        val yVals = ArrayList<CandleEntry>()
        val random = Random()
        for (i in 0 until 20) {
            val open = random.nextFloat() * 15 + 5
            val close = open + random.nextFloat() * 5 - 2.5f
            val high = Math.max(open, close) + random.nextFloat()
            val low = Math.min(open, close) - random.nextFloat()
            yVals.add(CandleEntry(i.toFloat(), high, low, open, close))
        }

        /*yVals.add(CandleEntry(0f, 10f, 8f, 9f, 9.5f))
        yVals.add(CandleEntry(1f, 9f, 7f, 8f, 8.5f))
        yVals.add(CandleEntry(2f, 8f, 6f, 7f, 7.5f))
        yVals.add(CandleEntry(3f, 7f, 5f, 6f, 6.5f))
        yVals.add(CandleEntry(4f, 6f, 4f, 5f, 5.5f))*/


        val set = CandleDataSet(yVals, "Candle Stick Data")
        //set.color = Color.rgb(80, 80, 80)
        set.shadowColor = Color.DKGRAY
        set.shadowWidth = 0.7f
        set.decreasingColor = Color.RED
        set.decreasingPaintStyle = Paint.Style.FILL
        set.increasingColor = Color.GREEN
        set.increasingPaintStyle = Paint.Style.FILL
        set.neutralColor = Color.BLUE
        set.valueTextSize = 16f

        // Set description as false
        candleStickChart.description.isEnabled = false

        candleStickChart.moveViewToX(yVals.size - 15f)


        val data = CandleData(set)
        candleStickChart.data = data
        candleStickChart.invalidate()

        candleStickChart.xAxis.textSize = 20f
        candleStickChart.axisRight.textSize = 20f
        candleStickChart.axisLeft.textSize = 20f
    }
}