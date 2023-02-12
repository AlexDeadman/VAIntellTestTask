package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Livescores(
    @SerializedName("data")
    var data: ArrayList<Data> = arrayListOf(),

    @SerializedName("meta")
    var meta: Meta? = Meta()
)