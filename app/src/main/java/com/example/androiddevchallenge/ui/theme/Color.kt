/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)

val yellow = Color(0xFFE3DA00)
val gray900 = Color(0xFF232323)
val gray700 = Color(0xFF2D2D2D)
val purple = Color(0xFF322049)
val white = Color(0xFFFFFFFF)
val green = Color(0xFF39A844)
val red = Color(0xD93C19)

val mLightColors = lightColors(
    primary = yellow,
    onPrimary = gray900,
    background = purple,
    onBackground = white,
    surface = white,
    onSurface = gray900,
    secondary = green,
    onSecondary = red
)

val mDarkColors = darkColors(
    primary = yellow,
    onPrimary = gray900,
    background = gray900,
    onBackground = white,
    surface = gray700,
    onSurface = white,
    secondary = green,
    onSecondary = red
)