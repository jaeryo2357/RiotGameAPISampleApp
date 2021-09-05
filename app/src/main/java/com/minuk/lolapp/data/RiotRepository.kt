package com.minuk.lolapp.data

import com.minuk.lolapp.network.model.Champions
import com.minuk.lolapp.network.Result

interface RiotRepository {
    suspend fun getChampions() : Result<Champions>
}