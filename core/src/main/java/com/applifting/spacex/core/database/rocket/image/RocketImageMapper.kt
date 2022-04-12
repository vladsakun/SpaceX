package com.applifting.spacex.core.database.rocket.image

import com.applifting.spacex.core.mapper.Mapper
import com.applifting.spacex.core.network.responses.rockets.RocketItem
import com.applifting.spacex.core.network.responses.rockets.RocketsResponse

/**
 * Created by Vlad Sakun on 07.04.2022
 */
class RocketImageMapper : Mapper<RocketsResponse, List<RocketImageEntity>> {

  override suspend fun map(from: RocketsResponse): List<RocketImageEntity> {
    val images = mutableListOf<RocketImageEntity>()

    from.forEach {
      images.addAll(convertRocketItemToRocketImageEntity(it))
    }

    return images
  }

  private fun convertRocketItemToRocketImageEntity(rocketItem: RocketItem): List<RocketImageEntity> {
    val imageEntities = mutableListOf<RocketImageEntity>()

    rocketItem.flickrImages?.forEach {
      imageEntities.add(
        RocketImageEntity(
          rocketOwnerId = rocketItem.id.orEmpty(),
          imageUrl = it
        )
      )
    }

    return imageEntities
  }
}