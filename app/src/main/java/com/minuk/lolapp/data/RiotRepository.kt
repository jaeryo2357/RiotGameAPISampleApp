package com.minuk.lolapp.data

import com.minuk.lolapp.network.model.PlayerDto
import com.minuk.lolapp.network.Result

interface RiotRepository {
    suspend fun getLeaderboards() : Result<PlayerDto>
}