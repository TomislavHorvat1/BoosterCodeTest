package com.booster.codetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.booster.codetestapp.framework.BoosterScreen.Landing
import com.booster.codetestapp.framework.BoosterScreen.OrderConfig
import com.booster.codetestapp.framework.BoosterScreen.DeliveryProgress
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.view.deliveryProgress.DeliveryProgressScreen
import com.booster.codetestapp.ui.view.landing.LandingScreen
import com.booster.codetestapp.ui.view.orderconfig.OrderConfigurationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BoosterCodeTestTheme {
                RootLayout()
            }
        }
    }
}

@Composable
fun RootLayout() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Landing.name,
    ) {
        composable(Landing.name) { LandingScreen { navController.navigate(OrderConfig.name) } }
        composable(OrderConfig.name) {
            OrderConfigurationScreen(
                onPlaceOrderClick = {
                    navController.popBackStack()
                    navController.navigate(DeliveryProgress.name)
                },
                onBack = { navController.popBackStack() },
            )
        }
        composable(DeliveryProgress.name) { DeliveryProgressScreen { navController.popBackStack() } }
    }
}
