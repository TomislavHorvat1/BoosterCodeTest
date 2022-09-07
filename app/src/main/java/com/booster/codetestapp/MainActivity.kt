package com.booster.codetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.view.landing.LandingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BoosterCodeTestTheme {
                LandingScreen()
            }
        }
    }
}