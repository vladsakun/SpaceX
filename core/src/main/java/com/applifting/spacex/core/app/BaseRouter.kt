package com.applifting.spacex.core.app

import com.applifting.spacex.core.database.rocket.RocketWithImage

/**
 * Created by Vlad Sakun on 09.04.2022
 */
interface BaseRouter {

  fun toCompanyFragment()

  fun toRocketsFragment()

  fun toRocketDetails(rocketWithImage: RocketWithImage)
}