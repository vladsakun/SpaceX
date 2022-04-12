package com.applifting.spacex.core.database.rocket.image

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Parcelize
@Entity(tableName = "rocket_images")
data class RocketImageEntity(
  val rocketOwnerId: String,
  val imageUrl: String
) : Parcelable {

  @IgnoredOnParcel
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  var imageId: Long = 0

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as RocketImageEntity

    if (rocketOwnerId != other.rocketOwnerId) return false
    if (imageUrl != other.imageUrl) return false

    return true
  }

  override fun hashCode(): Int {
    var result = rocketOwnerId.hashCode()
    result = 31 * result + imageUrl.hashCode()
    return result
  }

  override fun toString(): String {
    return "RocketImageEntity(rocketOwnerId='$rocketOwnerId', imageUrl='$imageUrl', imageId=$imageId)"
  }
}