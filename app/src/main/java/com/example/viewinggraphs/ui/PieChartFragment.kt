package com.example.viewinggraphs.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewinggraphs.R
import com.example.viewinggraphs.databinding.FragmentPieChartBinding
import com.example.viewinggraphs.network.PieChartInfo
import com.example.viewinggraphs.ui.viewmodel.PieChartVIewModel
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend

/**
 * A simple [Fragment] subclass.
 * Use the [PieChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieChartFragment : Fragment() {

    private val viewModel: PieChartVIewModel by viewModels()

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
        viewModel.dataPieAcquisition()
        //var dataList = viewModel.getDataPie()
        val pieChartView = view.findViewById<PieChart>(R.id.pie_graphic)
        /*val pie = context?.let { com.example.viewinggraphs.graphs.PieChart(pieChartView, it, dataList) }
        with(pie) {
            this?.createPieChart()
        }*/

        val observer = Observer<List<PieChartInfo>> { dataList ->
            val pie = context?.let {
                com.example.viewinggraphs.graphs.PieChart(
                    pieChartView,
                    it,
                    viewModel.getDataPie()
                )
            }
            with(pie) {
                this?.createPieChart()
            }

            val legend = pieChartView.legend
            legend.form = Legend.LegendForm.CIRCLE
            legend.formSize = 20f
            legend.textColor = Color.BLACK
            legend.textSize = 18f
            legend.xEntrySpace = 5f
            legend.yEntrySpace = 5f
            legend.isEnabled = true
        }
        viewModel.pie.observe(viewLifecycleOwner, observer)
    }
}