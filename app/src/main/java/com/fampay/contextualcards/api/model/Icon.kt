package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName


data class Icon (

  @SerializedName("image_type" ) var imageType : String? = null,
  @SerializedName("image_url"  ) var imageUrl  : String? = null

)