package com.booster.codetestapp.ui.view.deliveryProgress

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.theme.Purple200
import com.booster.codetestapp.ui.theme.Purple700
import com.booster.codetestapp.ui.view.orderconfig.SectionTitle

@Composable
fun SelectedOptionWindow(
    label: String,
    name: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            SectionTitle(
                title = label,
                subtitle = name
            )
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 0.dp,
                modifier = Modifier.align(CenterVertically)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Purple200,
                                    Purple700,
                                )
                            )
                        ),
                ) {
                    Text(
                        text = value,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedDeliveryWindowPreview() {
    BoosterCodeTestTheme {
        SelectedOptionWindow(
            label = "Selected delivery time",
            name = "morning",
            value = "7AM - 12PM",
            modifier = Modifier
        )
    }
}
