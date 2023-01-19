package com.example.viewinggraphs.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewinggraphs.network.PieChartApi
import com.example.viewinggraphs.network.PieChartInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class PieChartVIewModel : ViewModel() {

    private val _pie = MutableLiveData<List<PieChartInfo>>()

    val pie: LiveData<List<PieChartInfo>>
        get() = _pie

    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    /**
     * Function for acquiring pie chart data via API
     */
    fun dataPieAcquisition() = CoroutineScope(Dispatchers.Main).launch {
        try {
            if (_pie.value == null) {
                _pie.postValue(PieChartApi.retrofitService.getPieInfo())
            }

            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false

        } catch (networkError: IOException) {
            _eventNetworkError.value = true
        }
    }

    /**
     * Function to save pie chart data in a list by API
     */
    fun getDataPie(): List<Int> {
        return _pie.value?.map { e -> e.value }?.distinct() ?: emptyList()
    }

}