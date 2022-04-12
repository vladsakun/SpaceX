package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class Engines(
  @SerializedName("engine_loss_max")
  val engineLossMax: Double?,
  @SerializedName("isp")
  val isp: Isp?,
  @SerializedName("layout")
  val layout: String?,
  @SerializedName("number")
  val number: Double?,
  @SerializedName("propellant_1")
  val propellant1: String?,
  @SerializedName("propellant_2")
  val propellant2: String?,
  @SerializedName("thrust_sea_level")
  val thrustSeaLevel: ThrustSeaLevel?,
  @SerializedName("thrust_to_weight")
  val thrustToWeight: Double?,
  @SerializedName("thrust_vacuum")
  val thrustVacuum: ThrustVacuum?,
  @SerializedName("type")
  val type: String?,
  @SerializedName("version")
  val version: String?
)