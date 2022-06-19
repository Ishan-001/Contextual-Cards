package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName


data class FormattedTitle (

  @SerializedName("text"     ) var text     : String?             = null,
  @SerializedName("entities" ) var entities : ArrayList<Entities> = arrayListOf()

)