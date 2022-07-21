package com.example.socialmediaholdingtest1.ui.screens.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun BuyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors,
    shape: Shape,
    text: String,
    textSize: TextUnit,
    textColor: Color,
    fontWeight: FontWeight
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .fillMaxWidth(0.5f)
            .height(49.dp),
        colors = colors,
        shape = shape
    ) {
        Text(
            text = text,
            fontSize = textSize,
            color = textColor,
            fontWeight = fontWeight
        )
    }
}