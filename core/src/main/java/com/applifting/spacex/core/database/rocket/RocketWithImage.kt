package com.applifting.spacex.core.database.rocket

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.applifting.spacex.core.database.rocket.image.RocketImageEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Parcelize
class RocketWithImage(
  @Embedded val rocketEntity: RocketEntity,
  @Relation(
    parentColumn = "rocketId",
    entityColumn = "rocketOwnerId"
  )
  val rocketImageEntities: List<RocketImageEntity>
) : Parcelable {

  override fun toString(): String {
    return "RocketWithImage(rocketEntity=$rocketEntity, rocketImageEntities=$rocketImageEntities)"
  }
}