package com.example.androiddevchallenge

import androidx.annotation.DrawableRes

data class Trade(
    val code: String,
    val company: String,
    val price: String,
    val change: Float,
    @DrawableRes val pic: Int
)
