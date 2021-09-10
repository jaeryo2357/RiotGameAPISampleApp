package com.minuk.lolapp.data

import com.minuk.lolapp.network.Result
import com.minuk.lolapp.network.model.Champion

interface RiotRepository {
    suspend fun getChampions() : Result<List<Champion>>
}