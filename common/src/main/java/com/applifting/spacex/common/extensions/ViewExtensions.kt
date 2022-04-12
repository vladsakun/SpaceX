package com.applifting.spacex.common.extensions

import android.view.View
import android.widget.ImageView
import com.applifting.spacex.common.R
import com.applifting.spacex.common.listeners.OnSingleClickListener
import com.bumptech.glide.Glide

/**
 * Created by Vlad Sakun on 07.04.2022
 */
fun View.show() {
  if (this.visibility == View.VISIBLE) return

  this.visibility = View.VISIBLE
}

fun View.hide() {
  if (this.visibility == View.GONE) return

  this.visibility = View.GONE
}

fun ImageView.loadImage(url: String?) {
  Glide.with(this.context)
    .load(url)
    .error(R.drawable.ic_rocket)
    .into(this)
}

fun View.setOnSingleClickListener(action: () -> Unit) {
  setOnClickListener(object : OnSingleClickListener() {
    override fun onSingleClick(v: View) {
      action.invoke()
    }
  })
}