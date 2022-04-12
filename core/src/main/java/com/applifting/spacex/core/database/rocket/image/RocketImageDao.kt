package com.applifting.spacex.core.database.rocket.image

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Dao
interface RocketImageDao {

  @Query("SELECT * FROM $TABLE_NAME")
  suspend fun getAllImages(): List<RocketImageEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertRocketImage(rocketImageEntity: RocketImageEntity)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertRocketImages(rocketImages: List<RocketImageEntity>)

  @Query("DELETE FROM $TABLE_NAME")
  suspend fun deleteAllRocketImages()

  companion object {
    const val TABLE_NAME = "rocket_images"
  }
}