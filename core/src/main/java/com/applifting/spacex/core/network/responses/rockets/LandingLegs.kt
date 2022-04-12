package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class LandingLegs(
  @SerializedName("material")
  val material: String?,
  @SerializedName("number")
  val number: Double?
)