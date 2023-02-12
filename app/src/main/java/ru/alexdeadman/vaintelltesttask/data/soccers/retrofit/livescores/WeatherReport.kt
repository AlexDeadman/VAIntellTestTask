package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class WeatherReport(
    @SerializedName("desc")
    var desc: String? = null,

    @SerializedName("temp")
    var temp: Temp? = Temp(),

    @SerializedName("wind")
    var wind: Wind? = Wind(),

    @SerializedName("humidity_percent")
    var humidityPercent: Int? = null,

    @SerializedName("pressure")
    var pressure: Int? = null
)