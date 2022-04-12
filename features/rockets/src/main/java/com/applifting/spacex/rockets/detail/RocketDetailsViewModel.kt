package com.applifting.spacex.rockets.detail

import android.os.Bundle
import androidx.lifecycle.LiveData
import com.applifting.spacex.common.base.BaseViewModel
import com.applifting.spacex.common.base.INITIAL_ARGS
import com.applifting.spacex.common.livedata.ActiveMutableLiveData
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.core.extensions.formatPrice
import com.applifting.spacex.rockets.detail.image.RocketImageFragment
import com.applifting.spacex.rockets.detail.model.RocketDetailsUIModel
import com.applifting.spacex.rockets.detail.model.RocketDetailsViewState

/**
 * Created by Vlad Sakun on 09.04.2022
 */
private const val TAG = "RocketDetailsViewModel"

class RocketDetailsViewModel : BaseViewModel() {

  private var rocketWithImage: RocketWithImage? = null
  private var position = 0
  private var imagesAmount = -1

  private val _state = ActiveMutableLiveData<RocketDetailsViewState>()
  val state: LiveData<RocketDetailsViewState> = _state

  override fun onCreate(arguments: Bundle?) {
    arguments?.getParcelable<RocketWithImage>(INITIAL_ARGS)?.let {
      rocketWithImage = it
    }
  }

  fun onViewCreated() {
    rocketWithImage?.let { rocket ->

      val imageFragments = rocket.rocketImageEntities.map { RocketImageFragment.newInstance(it.imageUrl) }

      imagesAmount = imageFragments.size

      _state.setValue(
        RocketDetailsViewState.SetupUI(
          RocketDetailsUIModel(
            imageFragments = imageFragments,
            rocketName = rocket.rocketEntity.name,
            costPerLaunch = rocket.rocketEntity.costPerLaunch.formatPrice(),
            height = rocket.rocketEntity.height.formatPrice(),
            wikipedia = rocket.rocketEntity.wikipedia
          )
        )
      )
    }
  }

  fun nextImage() {
    if (position < imagesAmount - 1) {
      position++
    }

    _state.setValue(RocketDetailsViewState.GoToImage(position))
  }

  fun previousImage() {
    if (position > 0) {
      position--
    }

    _state.setValue(RocketDetailsViewState.GoToImage(position))
  }
}