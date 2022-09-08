package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.codetestapp.ui.theme.Purple200
import com.booster.codetestapp.ui.theme.Purple700

@Composable
fun GradientButton(
    enabled: Boolean = true,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val enabledGradient = Brush.horizontalGradient(
        colors = listOf(
            Purple200,
            Purple700,
        )
    )
    val disabledGradient = Brush.horizontalGradient(
        colors = listOf(
            Color.Gray,
            Color.Gray,
        )
    )

    Box(modifier = Modifier.padding(8.dp)) {
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            contentPadding = PaddingValues(),
            onClick = { onClick() },
        ) {
            Box(
                modifier = Modifier
                    .background(if (enabled) enabledGradient else disabledGradient)
                    .then(modifier),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = if (enabled) Color.White else Color.Black
                )
            }
        }
    }
}