package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores

import com.google.gson.annotations.SerializedName


data class Assistants (

  @SerializedName("first_assistant_id"  ) var firstAssistantId  : String? = null,
  @SerializedName("second_assistant_id" ) var secondAssistantId : String? = null,
  @SerializedName("fourth_assistant_id" ) var fourthAssistantId : String? = null

)