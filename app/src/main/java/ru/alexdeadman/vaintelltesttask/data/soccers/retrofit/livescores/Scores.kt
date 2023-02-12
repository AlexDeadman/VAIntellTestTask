package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Scores(
    @SerializedName("home_score")
    var homeScore: String? = null,

    @SerializedName("away_score")
    var awayScore: String? = null,

    @SerializedName("ht_score")
    var htScore: String? = null,

    @SerializedName("ft_score")
    var ftScore: String? = null,

    @SerializedName("et_score")
    var etScore: String? = null,

    @SerializedName("ps_score")
    var psScore: String? = null
)