package com.booster.codetestapp.ui.view

import androidx.compose.runtime.Composable
import com.booster.codetestapp.ui.view.landing.LandingScreen

enum class BoosterScreen(
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Map(body = { LandingScreen() }),
    DeliveryConfiguration(body = { DeliveryConfigurationScreen() }),
    DeliveryProgress(body = { DeliveryProgressScreen() }),
}