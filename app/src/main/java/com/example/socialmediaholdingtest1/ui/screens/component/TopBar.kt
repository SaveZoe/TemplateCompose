package com.example.socialmediaholdingtest1.ui.screens.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialmediaholdingtest1.R
import com.example.socialmediaholdingtest1.ui.theme.SocialMediaHoldingTest1Theme

@Composable
fun TopBar(
    @DrawableRes menuButton: Int,
    @DrawableRes actionButton: Int,
    menuAction: () -> Unit,
    action: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(id = menuButton),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 75.dp, height = 16.dp)
                    .clickable { menuAction.invoke() }
            )
            Image(
                painter = painterResource(id = actionButton),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable { action.invoke() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevTopBar() {
    SocialMediaHoldingTest1Theme {
        TopBar(
            menuButton = R.drawable.logo,
            actionButton = R.drawable.ic_search,
            menuAction = {},
            action = {}
        )
    }
}