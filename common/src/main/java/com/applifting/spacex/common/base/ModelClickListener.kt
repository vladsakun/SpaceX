package com.applifting.spacex.common.base

/**
 * Created by Vlad Sakun on 09.04.2022
 */
fun interface ModelClickListener<T> {
  fun onModelClick(model: T)
}