package com.booster.codetestapp.ui.view

import androidx.compose.runtime.Composable
import com.booster.codetestapp.ui.view.deliveryProgress.DeliveryProgressScreen
import com.booster.codetestapp.ui.view.landing.LandingScreen
import com.booster.codetestapp.ui.view.orderconfig.OrderConfigurationScreen

enum class BoosterScreen(
    val body: @Composable ((String) -> Unit) -> Unit,
) {
    Map(body = { LandingScreen() }),
    DeliveryConfiguration(body = { OrderConfigurationScreen() }),
    DeliveryProgress(body = { DeliveryProgressScreen() }),
}
