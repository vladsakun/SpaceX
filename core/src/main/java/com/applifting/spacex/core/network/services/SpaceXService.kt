package com.applifting.spacex.core.network.services

import com.applifting.spacex.core.network.responses.company.CompanyResponse
import com.applifting.spacex.core.network.responses.rockets.RocketsResponse
import retrofit2.http.GET

/**
 * Created by Vlad Sakun on 06.04.2022
 */
interface SpaceXService {

  @GET("/v4/rockets")
  suspend fun getRockets(): RocketsResponse

  @GET("/v4/company")
  suspend fun getCompany(): CompanyResponse

}