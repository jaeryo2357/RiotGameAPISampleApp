package com.minuk.lolapp.data

import com.minuk.lolapp.network.Result
import com.minuk.lolapp.ui.champion.ChampionModel

interface RiotRepository {
    suspend fun getChampions() : Result<List<ChampionModel>>
}