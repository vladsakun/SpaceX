package com.applifting.spacex.core.database.company

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Dao
interface CompanyDao {

  @Query("SELECT * FROM $TABLE_NAME")
  suspend fun getCompany(): CompanyEntity

  @Query("SELECT * FROM $TABLE_NAME")
  fun observeCompany(): Flow<CompanyEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertCompany(companyEntity: CompanyEntity)

  @Query("DELETE FROM $TABLE_NAME")
  suspend fun deleteAllCompanies()

  companion object {
    const val TABLE_NAME = "companies"
  }
}