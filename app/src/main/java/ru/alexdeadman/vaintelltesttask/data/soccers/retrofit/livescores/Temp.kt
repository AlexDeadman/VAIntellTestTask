package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Temp(
    @SerializedName("celsius")
    var celsius: Int? = null,

    @SerializedName("fahrenheit")
    var fahrenheit: Double? = null
)