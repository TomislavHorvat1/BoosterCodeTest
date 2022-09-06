package com.booster.codetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.booster.codetestapp.data.provider.PreferencesProvider
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.view.landing.LandingScreen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val prefs: PreferencesProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BoosterCodeTestTheme {
                LandingScreen()
            }
        }
    }
}