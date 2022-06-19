package com.fampay.contextualcards.api.model

import com.google.gson.annotations.SerializedName

data class Cards (
  @SerializedName("name"                  ) var name                 : String?               = null,
  @SerializedName("title"                 ) var title                : String?               = null,
  @SerializedName("formatted_title"       ) var formattedTitle       : FormattedTitle?       = FormattedTitle(),
  @SerializedName("description"           ) var description          : String?               = null,
  @SerializedName("formatted_description" ) var formattedDescription : FormattedDescription? = FormattedDescription(),
  @SerializedName("icon"                  ) var icon                 : Icon?                 = Icon(),
  @SerializedName("url"                   ) var url                  : String?               = null,
  @SerializedName("cta"                   ) var cta                  : ArrayList<Cta>        = arrayListOf(),
  @SerializedName("bg_image"              ) var backgroundImage      : BackgroundImage       = BackgroundImage(),
  @SerializedName("bg_color"              ) var backgroundColor      : String?               = null
)