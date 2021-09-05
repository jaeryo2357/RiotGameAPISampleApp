package com.minuk.lolapp.data

import com.minuk.lolapp.network.RiotService
import com.minuk.lolapp.network.model.Champions
import com.minuk.lolapp.network.Result
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val riotService: RiotService
) : RiotRepository {

    override suspend fun getChampions(): Result<Champions> {
        val result = riotService.getChampion()

        return if (result.statusCode != 200) {
            Result.Error(message = result.message)
        } else {
            Result.Success(result)
        }
    }
}