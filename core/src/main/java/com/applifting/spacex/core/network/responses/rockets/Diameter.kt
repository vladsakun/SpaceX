package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class Diameter(
  @SerializedName("feet")
  val feet: Double?,
  @SerializedName("meters")
  val meters: Double?
)