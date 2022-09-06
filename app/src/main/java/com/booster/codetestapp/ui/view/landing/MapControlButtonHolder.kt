package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MapControlButtonHolder(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(42.dp)
            .wrapContentWidth()
    ) {
        Card {
            Row {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        tint = Color.DarkGray,
                        contentDescription = null,
                        modifier = Modifier
                            .width(42.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(color = Color.LightGray)
                )
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.MyLocation,
                        tint = Color.DarkGray,
                        contentDescription = null,
                        modifier = Modifier
                            .width(42.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}