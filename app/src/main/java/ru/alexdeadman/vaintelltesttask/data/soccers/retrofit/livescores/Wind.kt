package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Wind(
    @SerializedName("kmph")
    var kmph: Int? = null,

    @SerializedName("miles")
    var miles: Double? = null,

    @SerializedName("direction")
    var direction: String? = null
)