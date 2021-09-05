package com.minuk.lolapp.ui.champion

import kotlinx.serialization.Serializable

@Serializable
data class ChampionModel(
    val version: String,
    val id: String,
    val name: String,
    val title: String,
    val blurb: String,
    val summaryImage: String,
    val loadingImage: String
)
