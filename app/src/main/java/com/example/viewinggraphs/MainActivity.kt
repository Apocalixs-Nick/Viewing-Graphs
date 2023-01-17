package com.example.viewinggraphs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewinggraphs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
/*
    // Variable indicating graph
    lateinit var barChart: BarChart

    // Variable for data acquisition in the graph
    lateinit var barData: BarData

    // Variable for setting the data in the graph
    lateinit var barDataSet: BarDataSet

    // Variable for creating an Array list for bar data
    lateinit var barEntriesList: ArrayList<BarEntry>*/

    //private lateinit var switchButton: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val viewPager = findViewById<ViewPager>(R.id.pager)
        viewPager.adapter = ScrollPagesFragment(supportFragmentManager)*/
        /*val barChartView = findViewById<com.github.mikephil.charting.charts.BarChart>(R.id.bar_graphic)
        val bar = BarChart(barChartView,this.applicationContext)
        bar.setBarChartData()

        val pieChartView = findViewById<PieChart>(R.id.pie_graphic)
        val pie = com.example.viewinggraphs.graphs.PieChart(pieChartView,this.applicationContext)
        pie.setPieChartData()*/
        /*switchButton = findViewById(R.id.switch_button)
        switchButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.barGraphic.visibility = View.VISIBLE
            } else {
                binding.barGraphic.visibility = View.GONE
                binding.pieGraphic.visibility = View.VISIBLE
            }
        }*/


    }

/*
    fun setBarChartData() {
        /*
        //x axis values

        val xvalue = ArrayList<String>()
        xvalue.add("Monday")
        xvalue.add("Tuesday")
        xvalue.add("Wednesday")
        xvalue.add("Thursday")
        xvalue.add("Saturday")
        xvalue.add("Sunday")

        //y axis values or bar data

        val barEntry = ArrayList<BarEntry>()
        barEntry.add(BarEntry(4f, 0f))
        barEntry.add(BarEntry(3.5f,1f))
        barEntry.add(BarEntry(8.9f,2f))
        barEntry.add(BarEntry(5.6f,3f))
        barEntry.add(BarEntry(2f,4f))
        barEntry.add(BarEntry(6f,5f))


        val barDataSet = BarDataSet(barEntry, "First")
        barDataSet.color = resources.getColor(R.color.black)

        val data = BarData(xvalue, barDataSet)
        binding.apply {
            graphic1.data = data
            graphic1.setBackgroundColor(resources.getColor(R.color.purple_200))
            graphic1.animateXY(3000, 3000)
        }*/

        // Graph acquisition
        barChart = findViewById(R.id.graphic1)

        //Function call to add data to list of Arrays
        getBarChartData()

        // Adding data to the graph
        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")

        // Data initialization
        barData = BarData(barDataSet)

        //Setting the data in the graph
        barChart.data = barData

        // Setting bar color
        barDataSet.color = resources.getColor(R.color.purple_500)

        // Text size
        barDataSet.valueTextSize = 12f

        // Set description as false
        barChart.description.isEnabled = false

    }

    /**
     * Private function to add data to the list of items in our bar
     */
    private fun getBarChartData() {
        barEntriesList = ArrayList()

        // Adding the data
        barEntriesList.add(BarEntry(1f, 1f))
        barEntriesList.add(BarEntry(2f, 2f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 4f))
        barEntriesList.add(BarEntry(5f, 5f))

    }*/
}