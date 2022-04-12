package com.applifting.spacex.core

import com.applifting.spacex.core.database.rocket.RocketEntity
import com.applifting.spacex.core.database.rocket.RocketMapper
import com.applifting.spacex.core.network.responses.rockets.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

/**
 * Created by Vlad Sakun on 12.04.2022
 */
class RocketMapperTest {

  private val mapper = RocketMapper()

  @Test
  fun `rocket response to entity mapping`() = runBlocking {

    val rocketResponse = RocketsResponse().apply {
      addAll(
        listOf(
          RocketItem(
            active = null,
            boosters = null,
            company = null,
            costPerLaunch = 20.0,
            country = null,
            description = null,
            diameter = Diameter(
              feet = null,
              meters = 2.0
            ),
            engines = null,
            firstFlight = null,
            firstStage = null,
            flickrImages = listOf(),
            height = Height(
              feet = null,
              meters = 1.0
            ),
            id = "1",
            landingLegs = null,
            mass = Mass(
              kg = 3.0,
              lb = null
            ),
            name = "Falcon",
            payloadWeights = listOf(),
            secondStage = null,
            stages = null,
            successRatePct = null,
            type = "rocket",
            wikipedia = "wiki"
          ),
        )
      )
    }

    val rocketEntity = RocketEntity(
      id = "1",
      name = "Falcon",
      type = "rocket",
      height = 1.0,
      diameter = 2.0,
      mass = 3.0,
      costPerLaunch = 20.0,
      wikipedia = "wiki"
    )

    Assert.assertEquals(rocketEntity, mapper.map(rocketResponse).first())
  }
}