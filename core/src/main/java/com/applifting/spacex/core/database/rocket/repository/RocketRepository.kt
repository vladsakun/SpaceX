package com.applifting.spacex.core.database.rocket.repository

import com.applifting.spacex.core.database.rocket.RocketDao
import com.applifting.spacex.core.database.rocket.RocketEntity
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.core.database.rocket.image.RocketImageDao
import com.applifting.spacex.core.database.rocket.image.RocketImageEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vlad Sakun on 06.04.2022
 */
class RocketRepository(
  private val rocketDao: RocketDao,
  private val rocketImageDao: RocketImageDao
) : RocketRepositoryContract {

  override suspend fun getAllRockets(): List<RocketEntity> {
    return rocketDao.getAllRockets()
  }

  override fun observeAllRocketsWithImages(): Flow<List<RocketWithImage>> {
    return rocketDao.observeRocketsWithImages()
  }

  override suspend fun getAllImages(): List<RocketImageEntity> {
    return rocketImageDao.getAllImages()
  }

  override suspend fun getAllRocketsWithImages(): List<RocketWithImage> {
    return rocketDao.getRocketsWithImages()
  }

  override suspend fun saveRockets(rockets: List<RocketEntity>) {
    rocketDao.insertRockets(rockets)
  }

  override suspend fun saveRocket(rocket: RocketEntity) {
    rocketDao.insertRocket(rocket)
  }

  override suspend fun saveRocketImages(rocketImages: List<RocketImageEntity>) {
    rocketImageDao.insertRocketImages(rocketImages)
  }

  override suspend fun saveRocketImage(rocketImage: RocketImageEntity) {
    rocketImageDao.insertRocketImage(rocketImage)
  }

  override suspend fun deleteRockets() {
    rocketDao.deleteAllRockets()
  }

  override suspend fun deleteRocketImages() {
    rocketImageDao.deleteAllRocketImages()
  }

  override suspend fun clear() {
    deleteRockets()
    deleteRocketImages()
  }
}