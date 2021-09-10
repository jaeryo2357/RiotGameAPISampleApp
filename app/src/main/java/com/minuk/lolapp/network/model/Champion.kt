package com.minuk.lolapp.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Champion(
    @SerializedName("version")
    @Expose
   val version: String,

    @SerializedName("id")
    @Expose
   val id: String,

    @SerializedName("name")
    @Expose
   val name: String,

    @SerializedName("blurb")
    @Expose
   val blurb: String
) {
    var summaryIconUrl: String? = null
}
