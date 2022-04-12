package com.applifting.spacex.core.network.repositories

/**
 * Created by Vlad Sakun on 06.04.2022
 */
interface SpaceXRepositoryContract {

  suspend fun fetchRockets()

  suspend fun fetchCompany()
}