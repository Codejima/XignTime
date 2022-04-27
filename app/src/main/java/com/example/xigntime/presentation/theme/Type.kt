package com.example.xigntime.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.xigntime.R

val rubik = FontFamily(
    Font(R.font.rubik_light, FontWeight.Light),
    Font(R.font.rubik_medium, FontWeight.Medium),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_regular, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = XignSysBlueLight
    ),
    h1 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = XignSysBlueLight
    ),
    h2 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = XignSysBlueLight
    ),
    body2 = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = XignSysBlueLight
    )

)