package com.applifting.spacex.core.network.responses.rockets

import com.google.gson.annotations.SerializedName

data class PayloadWeight(
  @SerializedName("id")
  val id: String?,
  @SerializedName("kg")
  val kg: Double?,
  @SerializedName("lb")
  val lb: Double?,
  @SerializedName("name")
  val name: String?
)