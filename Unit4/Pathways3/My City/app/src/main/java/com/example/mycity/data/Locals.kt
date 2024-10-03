/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mycity.data

import com.example.locals.R
import com.example.locals.model.Local

/**
 * locals data
 */
object Locals {
    val defaultSport = getlocalsData()[0]

    fun getlocalsData(): List<Local> {
        return listOf(
            Local(
                id = 1,
                titleResourceId = R.string.baseball,
                subtitleResourceId = R.string.locals_list_subtitle,
                
            ),
            Local(
                id = 2,
                titleResourceId = R.string.badminton,
                subtitleResourceId = R.string.locals_list_subtitle,
            ),
            Local(
                id = 3,
                titleResourceId = R.string.basketball,
                subtitleResourceId = R.string.locals_list_subtitle,
                
            ),
            
        )
    }
}
