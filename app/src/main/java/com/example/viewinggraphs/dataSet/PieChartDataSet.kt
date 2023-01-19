package com.example.viewinggraphs.dataSet

import android.content.Context
import android.util.Log
import com.example.viewinggraphs.ui.viewmodel.PieChartVIewModel
import com.github.mikephil.charting.data.PieEntry
import java.util.*
import kotlin.collections.ArrayList

class PieChartDataSet(private val dataList: List<Int>) {

    /*fun setDataPieChart(): ArrayList<PieEntry> {
        viewModel.dataPieAcquisition()

        val listInt = viewModel.getDataPie()
        val entries: ArrayList<PieEntry> = ArrayList()
        for (i in 0 until 6) {
            entries.add(PieEntry(listInt.toFloat()))
        }

        /*entries.add(PieEntry(45f))
        entries.add(PieEntry(10f))
        entries.add(PieEntry(5f))
        entries.add(PieEntry(15f))
        entries.add(PieEntry(5f))
        entries.add(PieEntry(5f))
        entries.add(PieEntry(10f))
        entries.add(PieEntry(5f))*/
        return entries
    }*/

    fun setDataPieChart(): ArrayList<PieEntry> {
        val dataPie = dataList
        val entries: ArrayList<PieEntry> = ArrayList()
        for (i in dataPie.indices) {
            entries.add(PieEntry(dataPie[i].toFloat()))
        }
        return entries
    }
}