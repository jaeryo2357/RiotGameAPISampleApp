package com.minuk.lolapp.data

import com.minuk.lolapp.network.Result
import com.minuk.lolapp.network.RiotService
import com.minuk.lolapp.network.model.Champion
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val riotService: RiotService
) : RiotRepository {

    override suspend fun getChampions(): Result<List<Champion>> {
        val result = riotService.getChampion()

        return if (result.statusCode != null) {
            Result.Error(message = result.message)
        } else {
            Result.Success(
                result.data.values.toList().onEach {
                    it.summaryIconUrl = "http://ddragon.leagueoflegends.com/cdn/11.17.1/img/champion/${it.id}.png"
                }
            )
        }
    }
}