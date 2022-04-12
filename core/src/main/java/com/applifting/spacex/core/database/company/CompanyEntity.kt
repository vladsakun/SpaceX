package com.applifting.spacex.core.database.company

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Entity(tableName = "companies")
data class CompanyEntity(
  @PrimaryKey(autoGenerate = false)
  val id: String,
  @ColumnInfo(name = "name")
  val name: String,
  @ColumnInfo(name = "founder")
  val founder: String,
  @ColumnInfo(name = "summary")
  val summary: String,
  @ColumnInfo(name = "employees")
  val employees: Double
)