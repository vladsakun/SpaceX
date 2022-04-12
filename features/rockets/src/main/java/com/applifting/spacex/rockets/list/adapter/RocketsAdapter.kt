package com.applifting.spacex.rockets.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.applifting.spacex.common.R
import com.applifting.spacex.common.base.ModelClickListener
import com.applifting.spacex.common.extensions.loadImage
import com.applifting.spacex.common.extensions.setOnSingleClickListener
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.core.extensions.formatPrice
import com.applifting.spacex.rockets.databinding.RocketItemBinding

/**
 * Created by Vlad Sakun on 08.04.2022
 */
class RocketsAdapter(
  private val modelClickListener: ModelClickListener<RocketWithImage>
) : ListAdapter<RocketWithImage, RocketsAdapter.RocketsViewHolder>(
  object : DiffUtil.ItemCallback<RocketWithImage>() {
    override fun areItemsTheSame(old: RocketWithImage, new: RocketWithImage): Boolean =
      old.rocketEntity == new.rocketEntity

    override fun areContentsTheSame(old: RocketWithImage, new: RocketWithImage): Boolean =
      old.rocketEntity == new.rocketEntity
  }
) {

  inner class RocketsViewHolder(private val binding: RocketItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(rocketItem: RocketWithImage) {
      with(binding) {
        val context = root.context
        tvRocketName.text = context.getString(R.string.rocket_name, rocketItem.rocketEntity.name)
        val costPerLaunchString = rocketItem.rocketEntity.costPerLaunch.formatPrice()
        tvRocketCostPerLaunch.text =
          context.getString(R.string.rocket_cost_per_launch, costPerLaunchString)
        ivRocketImage.loadImage(rocketItem.rocketImageEntities.firstOrNull()?.imageUrl)

        root.setOnSingleClickListener {
          modelClickListener.onModelClick(rocketItem)
        }
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketsViewHolder {
    return RocketsViewHolder(RocketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun onBindViewHolder(holder: RocketsViewHolder, position: Int) {
    holder.onBind(getItem(position))
  }
}