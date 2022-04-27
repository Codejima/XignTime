package com.example.xigntime.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = XignSysBlue,
    secondary = XignSysOrange,
    background = XignSysBlueDark,
    onBackground = XignSysGreyLight,
    onPrimary = XignSysGreyLight,
    surface = XignSysBlueDark,
    onSurface = XignSysGreyLight
)

@Composable
fun XignTimeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}