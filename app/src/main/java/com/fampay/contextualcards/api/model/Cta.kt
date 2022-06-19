package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName

data class Cta(
    @SerializedName("text") var text : String? = null,
    @SerializedName("bg_color") var bgColor : String? = null,
    @SerializedName("text_color") var textColor : String? = null,
    @SerializedName("url") var url : String? = null
)
