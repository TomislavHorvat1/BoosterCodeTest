package com.booster.codetestapp.ui.view

import androidx.compose.runtime.Composable

enum class BoosterScreen(
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Map(body = { MapScreen() }),
    DeliveryConfiguration(body = { DeliveryConfigurationScreen() }),
    DeliveryProgress(body = { DeliveryProgressScreen() }),
}