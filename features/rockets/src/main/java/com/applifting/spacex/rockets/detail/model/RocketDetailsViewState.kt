package com.applifting.spacex.rockets.detail.model

/**
 * Created by Vlad Sakun on 09.04.2022
 */
sealed class RocketDetailsViewState {

  class SetupUI(val rocketDetailsUIModel: RocketDetailsUIModel) : RocketDetailsViewState()

  class GoToImage(val position: Int) : RocketDetailsViewState()

}