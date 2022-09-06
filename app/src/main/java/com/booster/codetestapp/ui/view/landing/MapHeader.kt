package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.theme.TransparentWhite
import com.booster.codetestapp.ui.theme.TransparentBlack

@Composable
fun MapHeader(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(TransparentBlack, Color.Transparent)
                )
            )
    ) {
        Text(
            text = "Order a Boost",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp),
        )
        Text(
            text = "Zoom & drag map to pin exact spot",
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            color = TransparentWhite,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapCardPreview() {
    BoosterCodeTestTheme {
        Box(modifier = Modifier.wrapContentSize()) {
            MapHeader(modifier = Modifier.align(Alignment.TopStart))
        }

    }
}