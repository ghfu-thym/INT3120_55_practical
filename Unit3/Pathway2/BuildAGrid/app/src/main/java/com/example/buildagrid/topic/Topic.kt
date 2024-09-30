package com.example.buildagrid.topic

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

data class Topic(

    @StringRes val stringResId: Int,
    val numberOfCourse:Int,
    @DrawableRes val drawableResId: Int,

)