package com.minuk.lolapp.network

import com.google.gson.annotations.SerializedName

open class Status (
    @SerializedName("message") val message : String? = null,
    @SerializedName("status_code") val statusCode: Int? = 200
)