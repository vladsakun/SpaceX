package com.applifting.spacex.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.applifting.spacex.core.database.company.CompanyDao
import com.applifting.spacex.core.database.company.CompanyEntity
import com.applifting.spacex.core.database.rocket.RocketDao
import com.applifting.spacex.core.database.rocket.RocketEntity
import com.applifting.spacex.core.database.rocket.image.RocketImageDao
import com.applifting.spacex.core.database.rocket.image.RocketImageEntity

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Database(
  entities = [RocketEntity::class, RocketImageEntity::class, CompanyEntity::class],
  version = 1
)
abstract class SpaceXDatabase : RoomDatabase() {

  /**
   * Get rocket data access object.
   *
   * @return rocket dao.
   */
  abstract fun rocketDao(): RocketDao

  /**
   * Get rocket image data access object.
   *
   * @return rocket image dao.
   */
  abstract fun rocketImageDao(): RocketImageDao

  /**
   * Get company data access object.
   *
   * @return company dao.
   */
  abstract fun companyDao(): CompanyDao
}