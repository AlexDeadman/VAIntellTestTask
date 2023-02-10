package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class League (

  @SerializedName("id"           ) var id          : Int?    = null,
  @SerializedName("name"         ) var name        : String? = null,
  @SerializedName("type"         ) var type        : String? = null,
  @SerializedName("country_id"   ) var countryId   : String? = null,
  @SerializedName("country_name" ) var countryName : String? = null,
  @SerializedName("country_code" ) var countryCode : String? = null,
  @SerializedName("country_flag" ) var countryFlag : String? = null

)