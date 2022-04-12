package com.applifting.spacex.rockets.detail.model

import com.applifting.spacex.rockets.detail.image.RocketImageFragment

/**
 * Created by Vlad Sakun on 09.04.2022
 */
data class RocketDetailsUIModel(
  val imageFragments: List<RocketImageFragment>,
  val rocketName: String,
  val costPerLaunch: String,
  val height: String,
  val wikipedia: String
)