package com.applifting.spacex.core.database.rocket.repository

import com.applifting.spacex.core.database.rocket.RocketEntity
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.core.database.rocket.image.RocketImageEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vlad Sakun on 07.04.2022
 */
interface RocketRepositoryContract {

  suspend fun getAllRockets(): List<RocketEntity>

  fun observeAllRocketsWithImages(): Flow<List<RocketWithImage>>

  suspend fun getAllImages(): List<RocketImageEntity>

  suspend fun getAllRocketsWithImages(): List<RocketWithImage>

  suspend fun saveRockets(rockets: List<RocketEntity>)

  suspend fun saveRocket(rocket: RocketEntity)

  suspend fun saveRocketImages(rocketImages: List<RocketImageEntity>)

  suspend fun saveRocketImage(rocketImage: RocketImageEntity)

  suspend fun deleteRockets()

  suspend fun deleteRocketImages()

  suspend fun clear()
}