package com.minuk.lolapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.minuk.lolapp.network.Status

data class Champions (
    @SerializedName("type")
    @Expose
    val type: String,

    @SerializedName("format")
    @Expose
    val format: String,

    @SerializedName("version")
    @Expose
    val version: String,

    @SerializedName("data")
    @Expose
    val data: Map<String, Champion>
) : Status()
