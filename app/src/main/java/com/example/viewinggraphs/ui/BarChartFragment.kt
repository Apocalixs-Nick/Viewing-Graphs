package com.example.viewinggraphs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewinggraphs.R
import com.example.viewinggraphs.databinding.FragmentBarChartBinding
import com.example.viewinggraphs.graphs.BarChart

/**
 * A simple [Fragment] subclass.
 * Use the [BarChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarChartFragment : Fragment() {

    private var _binding: FragmentBarChartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBarChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val barChartView = view.findViewById<com.github.mikephil.charting.charts.BarChart>(R.id.bar_graphic)
        val bar = context?.let { BarChart(barChartView, it) }
        with(bar) {
            this?.setBarChartData()
        }
    }

}