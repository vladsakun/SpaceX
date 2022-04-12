package com.applifting.spacex.rockets.list.model

import com.applifting.spacex.core.database.rocket.RocketWithImage

/**
 * Created by Vlad Sakun on 07.04.2022
 */
sealed class RocketsViewState {

  class SetRocketsData(val rocketWithImages: List<RocketWithImage>) : RocketsViewState()

  object ShowLoader : RocketsViewState()

  object HideLoader : RocketsViewState()
}