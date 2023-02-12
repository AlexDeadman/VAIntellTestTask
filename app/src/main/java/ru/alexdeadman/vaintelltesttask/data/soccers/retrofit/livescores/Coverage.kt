package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Coverage(
    @SerializedName("has_lineups")
    var hasLineups: Int? = null,

    @SerializedName("has_tvs")
    var hasTvs: Int? = null,

    @SerializedName("has_standings")
    var hasStandings: Int? = null
)