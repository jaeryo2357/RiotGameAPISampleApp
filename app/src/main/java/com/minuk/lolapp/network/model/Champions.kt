package com.minuk.lolapp.network.model

import com.minuk.lolapp.network.Status
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Champions (
    val type: String,
    val format: Int,
    val version: Int,
    val data: JsonArray
) : Status()
