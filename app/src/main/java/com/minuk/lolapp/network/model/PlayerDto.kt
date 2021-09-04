package com.minuk.lolapp.network.model

import com.minuk.lolapp.network.Status
import kotlinx.serialization.Serializable

@Serializable
data class PlayerDto (
    val name: String,
    val rank: Int,
    val lp: Int
) : Status()
