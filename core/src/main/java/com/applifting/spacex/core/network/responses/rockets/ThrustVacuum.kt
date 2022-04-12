package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class ThrustVacuum(
  @SerializedName("kN")
  val kN: Double?,
  @SerializedName("lbf")
  val lbf: Double?
)