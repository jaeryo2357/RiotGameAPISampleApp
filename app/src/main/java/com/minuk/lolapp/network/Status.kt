package com.minuk.lolapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class Status (
    val message : String? = null,
    @SerialName("status_code") val statusCode: Int? = 200
)