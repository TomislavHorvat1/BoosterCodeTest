package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.R
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme

@Composable
fun CarPin(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.pin),
            contentDescription = null,
            modifier = modifier.size(42.dp)
        )
        Spacer(modifier = Modifier.size(42.dp))
    }
}

@Preview
@Composable
fun CarPinPreview() {
    BoosterCodeTestTheme {
        CarPin(modifier = Modifier)
    }
}