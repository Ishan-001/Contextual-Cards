package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName


data class Entities (

  @SerializedName("text"  ) var text  : String? = null,
  @SerializedName("color" ) var color : String? = null

)