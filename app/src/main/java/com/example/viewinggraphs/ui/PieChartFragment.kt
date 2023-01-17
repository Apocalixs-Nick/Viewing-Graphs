package com.example.viewinggraphs.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewinggraphs.R
import com.example.viewinggraphs.databinding.FragmentBarChartBinding
import com.example.viewinggraphs.databinding.FragmentPieChartBinding
import com.example.viewinggraphs.graphs.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend

/**
 * A simple [Fragment] subclass.
 * Use the [PieChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieChartFragment : Fragment() {

    private var _binding: FragmentPieChartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPieChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pieChartView = view.findViewById<PieChart>(R.id.pie_graphic)
        val pie = context?.let { com.example.viewinggraphs.graphs.PieChart(pieChartView, it) }
        with(pie) {
            this?.setPieChartData()
        }

        val legend = pieChartView.legend
        legend.form = Legend.LegendForm.CIRCLE
        legend.textColor = Color.BLACK
        legend.textSize = 12f
        legend.xEntrySpace = 5f
        legend.yEntrySpace = 5f
        legend.isEnabled = true
    }

}