package com.applifting.spacex.core.extensions

import kotlin.math.roundToLong

/**
 * Created by Vlad Sakun on 11.04.2022
 */

fun Double.formatPrice() = roundToLong().toBigDecimal().toPlainString()