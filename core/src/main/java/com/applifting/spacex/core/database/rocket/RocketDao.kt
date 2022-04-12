package com.applifting.spacex.core.database.rocket

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Dao
interface RocketDao {

  @Query("SELECT * FROM $TABLE_NAME")
  suspend fun getAllRockets(): List<RocketEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertRocket(rocketImageEntity: RocketEntity)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertRockets(rocketImages: List<RocketEntity>)

  @Query("DELETE FROM $TABLE_NAME")
  suspend fun deleteAllRockets()

  @Transaction
  @Query("SELECT * FROM  $TABLE_NAME")
  suspend fun getRocketsWithImages(): List<RocketWithImage>

  @Transaction
  @Query("SELECT * FROM  $TABLE_NAME")
  fun observeRocketsWithImages(): Flow<List<RocketWithImage>>

  companion object {
    const val TABLE_NAME = "rockets"
  }
}