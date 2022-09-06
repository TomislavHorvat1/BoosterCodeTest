package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.ui.theme.Purple200
import com.booster.codetestapp.ui.theme.Purple700
import com.booster.codetestapp.ui.viewmodel.LandingScreenViewModel

@Composable
fun LandingScreen() {

    val viewModel = LandingScreenViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp,
                content = { Toolbar() }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                MapCard()
                PricesFooter(
                    fuelPrice = viewModel.fuelPrice.value,
                )
                GradientButton(
                    text = "Next",
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            Purple200,
                            Purple700,
                        )
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                )
            }
        }
    }
}

@Composable
fun Toolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterStart),
        ) {
            Icon(Icons.Filled.Menu, null)
        }
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterEnd),
        ) {
            Icon(Icons.Outlined.HelpOutline, null)
        }
    }
}

