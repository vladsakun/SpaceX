package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class SecondStage(
  @SerializedName("burn_time_sec")
  val burnTimeSec: Double?,
  @SerializedName("engines")
  val engines: Double?,
  @SerializedName("fuel_amount_tons")
  val fuelAmountTons: Double?,
  @SerializedName("payloads")
  val payloads: Payloads?,
  @SerializedName("reusable")
  val reusable: Boolean?,
  @SerializedName("thrust")
  val thrust: Thrust?
)