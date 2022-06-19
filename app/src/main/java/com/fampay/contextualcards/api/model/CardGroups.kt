package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName


data class CardGroups (

    @SerializedName("id"            ) var id           : Int?             = null,
    @SerializedName("name"          ) var name         : String?          = null,
    @SerializedName("design_type"   ) var designType   : String?          = null,
    @SerializedName("cards"         ) var cards        : ArrayList<Cards> = arrayListOf(),
    @SerializedName("is_scrollable" ) var isScrollable : Boolean?         = null,
    @SerializedName("height"        ) var height       : Int?             = 0
)