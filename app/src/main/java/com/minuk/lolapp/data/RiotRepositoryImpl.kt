package com.minuk.lolapp.data

import com.minuk.lolapp.network.Result
import com.minuk.lolapp.network.RiotService
import com.minuk.lolapp.ui.champion.ChampionModel
import kotlinx.serialization.json.jsonObject
import javax.inject.Inject

class RiotRepositoryImpl @Inject constructor(
    private val riotService: RiotService
) : RiotRepository {

    override suspend fun getChampions(): Result<List<ChampionModel>> {
        val result = riotService.getChampion()

        return if (result.statusCode != 200) {
            Result.Error(message = result.message)
        } else {
            Result.Success(
                result.data.map { element ->
                    val jsonObject = element.jsonObject
                    ChampionModel(
                        version = result.version.toString(),
                        id = jsonObject["id"].toString(),
                        name = jsonObject["name"].toString(),
                        title = jsonObject["title"].toString(),
                        blurb = jsonObject["blurb"].toString(),
                        summaryImage = "http://ddragon.leagueoflegends.com/cdn/11.18.1/img/champion/" +
                            jsonObject["id"].toString() + ".png",
                        loadingImage = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" +
                            jsonObject["id"].toString() + "_0.jpg"
                    )
                }
            )
        }
    }
}