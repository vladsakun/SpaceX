package com.applifting.spacex.core.database.rocket

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Parcelize
@Entity(tableName = "rockets")
data class RocketEntity(
  @PrimaryKey(autoGenerate = false)
  @ColumnInfo(name = "rocketId")
  val id: String,
  @ColumnInfo(name = "name")
  val name: String,
  @ColumnInfo(name = "type")
  val type: String,
  @ColumnInfo(name = "height")
  val height: Double,
  @ColumnInfo(name = "diameter")
  val diameter: Double,
  @ColumnInfo(name = "mass")
  val mass: Double,
  @ColumnInfo(name = "costPerLaunch")
  val costPerLaunch: Double,
  @ColumnInfo(name = "wikipedia")
  val wikipedia: String
) : Parcelable {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RocketEntity

    if (id != other.id) return false
    if (name != other.name) return false
    if (type != other.type) return false
    if (height != other.height) return false
    if (diameter != other.diameter) return false
    if (mass != other.mass) return false
    if (costPerLaunch != other.costPerLaunch) return false
    if (wikipedia != other.wikipedia) return false

    return true
  }

  override fun hashCode(): Int {
    var result = id.hashCode()
    result = 31 * result + name.hashCode()
    result = 31 * result + type.hashCode()
    result = 31 * result + height.hashCode()
    result = 31 * result + diameter.hashCode()
    result = 31 * result + mass.hashCode()
    result = 31 * result + costPerLaunch.hashCode()
    result = 31 * result + wikipedia.hashCode()
    return result
  }

  override fun toString(): String {
    return "RocketEntity(id='$id', name='$name', type='$type', height=$height, diameter=$diameter, mass=$mass, costPerLaunch=$costPerLaunch, wikipedia='$wikipedia')"
  }

}