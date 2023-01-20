package com.example.viewinggraphs.dataSet

import android.util.Log
import com.github.mikephil.charting.data.PieEntry
import kotlin.collections.ArrayList

class PieChartDataSet(private val dataList: List<Int>) {

    fun setDataPieChart(): ArrayList<PieEntry> {
        val dataPie = dataList.shuffled().take(2)
        val entries: ArrayList<PieEntry> = ArrayList()
        for (i in dataPie.indices) {
            entries.add(PieEntry(dataPie[i].toFloat()))
            Log.i("Check", entries[i].value.toString())
        }
        if (dataPie.sum() < 100) {
            val remaining = 100 - dataPie.sum()
            entries.add(PieEntry(remaining.toFloat()))
            Log.i("CheckS", remaining.toString())
        }
        return entries
    }
}