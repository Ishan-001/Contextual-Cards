package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName

data class BackgroundImage(
    @SerializedName("image_type") var imageType : String? = null,
    @SerializedName("image_url") var imageUrl : String? = null,
    @SerializedName("aspect_ratio") var aspectRatio : Float? = null
)
