package com.example.viewinggraphs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.viewinggraphs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private var selectVisible = false

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.isNestedScrollingEnabled = false
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        /*findViewById<View>(R.id.select1).setOnClickListener {
            navController.navigate(R.id.barChartFragment)
        }
        findViewById<View>(R.id.select2).setOnClickListener {
            navController.navigate(R.id.pieChartFragment)
        }
        findViewById<View>(R.id.select3).setOnClickListener {
            navController.navigate(R.id.candleStickChartFragment)
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            /*R.id.setting -> {
                selectVisible = !selectVisible
                if (selectVisible) {
                    findViewById<View>(R.id.select1).visibility = View.VISIBLE
                    findViewById<View>(R.id.select2).visibility = View.VISIBLE
                    findViewById<View>(R.id.select3).visibility = View.VISIBLE
                    findViewById<Button>(R.id.select1).setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_bar, 0, 0, 0)
                    findViewById<Button>(R.id.select2).setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pie, 0, 0, 0)
                    findViewById<Button>(R.id.select3).setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_candle, 0, 0, 0)
                } else {
                    findViewById<View>(R.id.select1).visibility = View.GONE
                    findViewById<View>(R.id.select2).visibility = View.GONE
                    findViewById<View>(R.id.select3).visibility = View.GONE
                    findViewById<Button>(R.id.select1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    findViewById<Button>(R.id.select2).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    findViewById<Button>(R.id.select3).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                }
            }*/
            R.id.select1 -> navController.navigate(R.id.barChartFragment)
            R.id.select2 -> navController.navigate(R.id.pieChartFragment)
            R.id.select3 ->navController.navigate(R.id.candleStickChartFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}