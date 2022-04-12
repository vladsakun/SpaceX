package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class ThrustSeaLevel(
  @SerializedName("kN")
  val kN: Double?,
  @SerializedName("lbf")
  val lbf: Double?
)