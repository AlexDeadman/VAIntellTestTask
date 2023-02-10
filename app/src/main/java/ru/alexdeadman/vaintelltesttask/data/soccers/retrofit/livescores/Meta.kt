package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Meta (

  @SerializedName("requests_left" ) var requestsLeft : Int?    = null,
  @SerializedName("user"          ) var user         : String? = null,
  @SerializedName("plan"          ) var plan         : String? = null,
  @SerializedName("pages"         ) var pages        : Int?    = null,
  @SerializedName("page"          ) var page         : Int?    = null,
  @SerializedName("count"         ) var count        : Int?    = null,
  @SerializedName("total"         ) var total        : Int?    = null

)