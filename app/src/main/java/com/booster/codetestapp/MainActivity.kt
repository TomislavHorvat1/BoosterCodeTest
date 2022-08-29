package com.booster.codetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.booster.codetestapp.data.model.BoostOrder
import com.booster.codetestapp.data.provider.PreferencesProvider
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.view.CodeTestApp
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : ComponentActivity() {

    private val prefs: PreferencesProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BoosterCodeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CodeTestApp()
                }
            }
        }
    }
}