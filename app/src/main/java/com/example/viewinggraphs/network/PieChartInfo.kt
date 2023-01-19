package com.example.viewinggraphs.network

import com.google.gson.annotations.SerializedName

data class PieChartInfo(
    @SerializedName("value") val value: Int
)