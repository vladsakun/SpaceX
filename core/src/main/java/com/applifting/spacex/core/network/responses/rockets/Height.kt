package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class Height(
  @SerializedName("feet")
  val feet: Double?,
  @SerializedName("meters")
  val meters: Double?
)