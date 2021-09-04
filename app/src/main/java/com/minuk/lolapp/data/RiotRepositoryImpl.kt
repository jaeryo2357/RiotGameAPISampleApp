package com.minuk.lolapp.data

import com.minuk.lolapp.network.RiotService
import com.minuk.lolapp.network.model.PlayerDto
import com.minuk.lolapp.network.Result
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val riotService: RiotService
) : RiotRepository {

    override suspend fun getLeaderboards(): Result<PlayerDto> {
        val result = riotService.getLeaderboards()

        return if (result.statusCode != 200) {
            Result.Error(message = result.message)
        } else {
            Result.Success(result)
        }
    }
}