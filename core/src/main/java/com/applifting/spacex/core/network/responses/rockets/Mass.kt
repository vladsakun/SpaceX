package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class Mass(
  @SerializedName("kg")
  val kg: Double?,
  @SerializedName("lb")
  val lb: Double?
)