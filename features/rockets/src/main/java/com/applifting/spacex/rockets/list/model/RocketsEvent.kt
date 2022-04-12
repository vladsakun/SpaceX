package com.applifting.spacex.rockets.list.model

import com.applifting.spacex.core.database.rocket.RocketWithImage

/**
 * Created by Vlad Sakun on 09.04.2022
 */
sealed class RocketsEvent {

  class NavigateToDetails(val rocketWithImage: RocketWithImage) : RocketsEvent()
}
