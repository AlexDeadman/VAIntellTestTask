package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Standings(
    @SerializedName("home_position")
    var homePosition: Int? = null,

    @SerializedName("away_position")
    var awayPosition: Int? = null
)