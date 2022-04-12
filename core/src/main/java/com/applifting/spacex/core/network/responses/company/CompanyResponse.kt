package com.applifting.spacex.core.network.responses.company

import com.google.gson.annotations.SerializedName

data class CompanyResponse(
  @SerializedName("ceo")
  val ceo: String?,
  @SerializedName("coo")
  val coo: String?,
  @SerializedName("cto")
  val cto: String?,
  @SerializedName("cto_propulsion")
  val ctoPropulsion: String?,
  @SerializedName("employees")
  val employees: Double?,
  @SerializedName("founded")
  val founded: Double?,
  @SerializedName("founder")
  val founder: String?,
  @SerializedName("headquarters")
  val headquarters: Headquarters?,
  @SerializedName("id")
  val id: String?,
  @SerializedName("launch_sites")
  val launchSites: Double?,
  @SerializedName("links")
  val links: Links?,
  @SerializedName("name")
  val name: String?,
  @SerializedName("summary")
  val summary: String?,
  @SerializedName("test_sites")
  val testSites: Double?,
  @SerializedName("valuation")
  val valuation: Long?,
  @SerializedName("vehicles")
  val vehicles: Double?
)