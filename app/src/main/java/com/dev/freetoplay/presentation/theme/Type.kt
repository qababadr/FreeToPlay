package com.dev.freetoplay.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev.freetoplay.R

private val Kaiseiopti = FontFamily(
    Font(R.font.kaiseiopti_regular, FontWeight.W400),
    Font(R.font.kaiseiopti_medium, FontWeight.W500),
    Font(R.font.kaiseiopti_bold, FontWeight.W600),
)

val KaiseioptiTypography = Typography(
    h1 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Kaiseiopti,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Kaiseiopti,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)