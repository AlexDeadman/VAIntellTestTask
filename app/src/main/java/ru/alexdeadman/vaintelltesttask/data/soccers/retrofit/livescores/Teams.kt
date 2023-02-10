package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Teams (

  @SerializedName("home" ) var home : Home? = Home(),
  @SerializedName("away" ) var away : Away? = Away()

)