package com.applifting.spacex.rockets.detail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.applifting.spacex.rockets.detail.image.RocketImageFragment

/**
 * Created by Vlad Sakun on 09.04.2022
 */
class RocketImagesViewPagerAdapter(
  fa: FragmentActivity,
  private val imageFragments: List<RocketImageFragment>
) : FragmentStateAdapter(fa) {

  override fun getItemCount(): Int {
    return imageFragments.size
  }

  override fun createFragment(position: Int): Fragment {
    return imageFragments[position]
  }
}