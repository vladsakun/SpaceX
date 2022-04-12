package com.applifting.spacex.common.extensions

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

/**
 * Created by Vlad Sakun on 09.04.2022
 */
fun Context.convertDpToPix(dp: Float) =
  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).roundToInt()