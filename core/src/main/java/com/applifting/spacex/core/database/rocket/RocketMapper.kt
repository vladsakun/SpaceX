package com.applifting.spacex.core.database.rocket

import com.applifting.spacex.core.extensions.orZero
import com.applifting.spacex.core.mapper.Mapper
import com.applifting.spacex.core.network.responses.rockets.RocketItem
import com.applifting.spacex.core.network.responses.rockets.RocketsResponse

/**
 * Created by Vlad Sakun on 07.04.2022
 */
class RocketMapper : Mapper<RocketsResponse, List<RocketEntity>> {

  override suspend fun map(from: RocketsResponse): List<RocketEntity> {
    return from.map { convertRocketItemToEntity(it) }
  }

  private fun convertRocketItemToEntity(rocketItem: RocketItem): RocketEntity {
    return with(rocketItem) {
      RocketEntity(
        id = id.orEmpty(),
        name = name.orEmpty(),
        type = type.orEmpty(),
        height = height?.meters.orZero(),
        diameter = diameter?.meters.orZero(),
        mass = mass?.kg.orZero(),
        costPerLaunch = costPerLaunch.orZero(),
        wikipedia = wikipedia.orEmpty()
      )
    }
  }
}