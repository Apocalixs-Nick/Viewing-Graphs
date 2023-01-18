package com.example.viewinggraphs.graphs

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class CandleChart(private val candleStickChart: CandleStickChart, private val context: Context) {

    private var prevOpen by Delegates.notNull<Float>()
    private var prevClose by Delegates.notNull<Float>()

    fun setCandleChartData() {
        val yVals = ArrayList<CandleEntry>()
        val random = Random()

        //It is based from Heikin Ashi chart
        for (i in 0 until 50) {
            if (i == 0) {
                prevOpen = random.nextFloat() * 15 + 5
                prevClose = prevOpen + random.nextFloat() * 5 - 2.5f
            } else {
                prevOpen = (prevOpen + prevClose) / 2
                prevClose = prevOpen + random.nextFloat() * 5 - 2.5f
            }
            val high = Math.max(prevOpen, prevClose) + random.nextFloat()
            val low = Math.min(prevOpen, prevClose) - random.nextFloat()
            yVals.add(CandleEntry(i.toFloat(), high, low, prevOpen, prevClose))
        }


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
        set.setDrawValues(false)

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