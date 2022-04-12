package com.applifting.spacex.core.extensions

/**
 * Created by Vlad Sakun on 07.04.2022
 */

fun Double?.orZero(): Double = this ?: 0.0

fun Int?.orZero(): Int = this ?: 0