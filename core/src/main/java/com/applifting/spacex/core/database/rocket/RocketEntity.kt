package com.applifting.spacex.core.database.rocket

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Entity(tableName = "rockets")
data class RocketEntity(
  @PrimaryKey(autoGenerate = false)
  val id: String,
  @ColumnInfo(name = "name")
  val name: String,
  @ColumnInfo(name = "type")
  val type: String
)