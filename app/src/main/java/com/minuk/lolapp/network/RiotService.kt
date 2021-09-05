package com.minuk.lolapp.network

import com.minuk.lolapp.network.model.Champions
import retrofit2.http.GET

interface RiotService {
    @GET("champion.json")
    suspend fun getChampion() : Champions
}