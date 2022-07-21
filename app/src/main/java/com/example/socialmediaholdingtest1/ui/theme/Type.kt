package com.example.socialmediaholdingtest1.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.socialmediaholdingtest1.R

val fonts = FontFamily(
    Font(R.font.montserrat_medium, weight = FontWeight.Normal),
    Font(R.font.montserrat_regular, weight = FontWeight.Light),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(R.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(R.font.gt_sectra_fine_medium, style = FontStyle.Italic, weight = FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.White
    ),
    h1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    h2 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic
    ),
    subtitle1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)