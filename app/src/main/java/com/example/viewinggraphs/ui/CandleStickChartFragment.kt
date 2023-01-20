package com.example.viewinggraphs.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewinggraphs.R
import com.example.viewinggraphs.databinding.FragmentBarChartBinding
import com.example.viewinggraphs.databinding.FragmentCandleStickChartBinding
import com.example.viewinggraphs.graphs.BarChart
import com.example.viewinggraphs.graphs.CandleChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.YAxis

/**
 * A simple [Fragment] subclass.
 * Use the [CandleStickChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CandleStickChartFragment : Fragment() {

    private var _binding: FragmentCandleStickChartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCandleStickChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val candleChartView =
            view.findViewById<com.github.mikephil.charting.charts.CandleStickChart>(R.id.candle_graphic)
        val candle = context?.let { CandleChart(candleChartView, it) }
        with(candle) {
            this?.createCandleChart()
        }

        candleChartView.extraBottomOffset = 5f
        candleChartView.extraTopOffset = 10f

        candleChartView.setVisibleXRangeMaximum(30f)
        candleChartView.setVisibleYRangeMaximum(30f, YAxis.AxisDependency.LEFT)


        val legend = candleChartView.legend
        legend.form = Legend.LegendForm.LINE
        legend.formSize = 25f
        legend.textColor = context?.resources?.getColor(R.color.red)!!
        legend.textSize = 18f
        legend.xEntrySpace = 5f
        legend.yEntrySpace = 5f
        legend.isEnabled = true
    }
}