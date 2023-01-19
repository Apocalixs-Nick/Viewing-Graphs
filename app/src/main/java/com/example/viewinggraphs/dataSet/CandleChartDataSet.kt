package com.example.viewinggraphs.dataSet

import com.github.mikephil.charting.data.CandleEntry
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class CandleChartDataSet {

    private var prevOpen by Delegates.notNull<Float>()
    private var prevClose by Delegates.notNull<Float>()

    fun setDataCandleChart(): ArrayList<CandleEntry> {
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
        return yVals
    }
}