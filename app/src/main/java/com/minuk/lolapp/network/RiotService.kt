package com.minuk.lolapp.network

import com.minuk.lolapp.network.model.PlayerDto
import retrofit2.http.GET

interface RiotService {
    @GET("/lor/ranked/v1/leaderboards")
    suspend fun getLeaderboards() : PlayerDto
}