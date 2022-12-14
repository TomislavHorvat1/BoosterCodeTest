package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.ui.viewmodel.LandingScreenViewModel
import com.globallogic.core.domain.model.FuelPrice
import org.koin.androidx.compose.getViewModel

@Composable
fun LandingScreen(onNext: () -> Unit) {
    val viewModel: LandingScreenViewModel = getViewModel()
    val fuelPrice: FuelPrice? by viewModel.fuelPrice.observeAsState()

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
                MapCard(modifier = Modifier.weight(1f))
                PricesFooter(
                    regular = fuelPrice?.regular,
                    premium = fuelPrice?.premium,
                )
                GradientButton(
                    text = "Next",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = onNext
                )
            }
        }
    }
}

@Composable
private fun Toolbar() {
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
