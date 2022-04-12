package com.applifting.spacex.rockets.list

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.common.extensions.convertDpToPix
import com.applifting.spacex.common.extensions.hide
import com.applifting.spacex.common.extensions.observe
import com.applifting.spacex.common.extensions.show
import com.applifting.spacex.common.recyclerview.RecyclerViewItemDecoration
import com.applifting.spacex.common.recyclerview.SpacingParams
import com.applifting.spacex.core.app.BaseRouter
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.rockets.R
import com.applifting.spacex.rockets.databinding.FragmentRocketsBinding
import com.applifting.spacex.rockets.list.adapter.RocketsAdapter
import com.applifting.spacex.rockets.list.di.DaggerRocketsComponent
import com.applifting.spacex.rockets.list.di.RocketsModule
import com.applifting.spacex.rockets.list.model.RocketsViewState

private const val TAG = "RocketsFragment"
private const val ROCKETS_SPACING_DP = 20f

class RocketsFragment : BaseFragment<FragmentRocketsBinding, RocketsViewModel>(
  layoutId = R.layout.fragment_rockets
) {

  private val rocketsAdapter = RocketsAdapter { navigateToDetails(it) }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupUI()

    viewModel.onViewCreated()

    observe(viewModel.state, ::onStateChanged)
  }

  private fun setupUI() {
    viewBinding.etSearch.doAfterTextChanged {
      viewModel.searchTextChanged(it.toString())
    }

    viewBinding.tilSearch.setEndIconOnClickListener {
      viewBinding.etSearch.setText("")
      viewModel.editTextCleared()
    }

    setupRV()
  }

  private fun setupRV() {
    with(viewBinding.rvRockets) {
      adapter = rocketsAdapter
      layoutManager = LinearLayoutManager(requireContext())
      addItemDecoration(
        RecyclerViewItemDecoration(
          requireContext().convertDpToPix(ROCKETS_SPACING_DP),
          spacingParams = SpacingParams(
            isTopSpacing = true,
            isBottomSpacing = false,
            isRightSpacing = false,
            isLeftSpacing = false
          )
        )
      )
    }
  }

  private fun onStateChanged(viewState: RocketsViewState) {
    when (viewState) {
      is RocketsViewState.SetRocketsData -> rocketsAdapter.submitList(viewState.rocketWithImages)

      is RocketsViewState.HideLoader -> viewBinding.progressCircular.hide()

      is RocketsViewState.ShowLoader -> viewBinding.progressCircular.show()
    }
  }

  private fun navigateToDetails(rocketWithImage: RocketWithImage) {
    (activity as BaseRouter?)?.toRocketDetails(rocketWithImage)
  }

  override fun onStart() {
    super.onStart()
    viewBinding.etSearch.setText("")
  }

  override fun onInitDependencyInjection() {
    DaggerRocketsComponent
      .builder()
      .coreComponent(
        (requireCompatActivity().application as SpaceXAppContract).provideCoreComponent(requireContext())
      )
      .rocketsModule(RocketsModule(this))
      .build()
      .inject(this)
  }

  companion object {
    fun newInstance() = RocketsFragment()
  }
}