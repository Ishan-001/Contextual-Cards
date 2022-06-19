package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName


data class ApiResponse (

  @SerializedName("card_groups" ) var cardGroups : ArrayList<CardGroups> = arrayListOf()

)