package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globallogic.core.domain.model.Fuel

@Composable
fun PricesFooter(
    regular: Fuel?,
    premium: Fuel?,
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(CenterVertically)
                .fillMaxWidth(0.5f)
        ) {
            Text(
                text = regular?.name ?: "",
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = regular
                    ?.price
                    ?.formatCurrency(regular.currency) ?: "",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Divider(
            modifier = Modifier
                .height(44.dp)
                .width(1.dp)
                .align(CenterVertically)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .align(CenterVertically)
                .fillMaxWidth(1f)
                .wrapContentHeight()
        ) {
            Text(
                text = premium?.name ?: "",
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = premium
                    ?.price
                    ?.formatCurrency(premium.currency) ?: "",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

private fun Double.formatCurrency(currency: String): String = String.format("$currency%.2f", this)
