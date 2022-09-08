package com.booster.codetestapp.ui.view.orderconfig

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.booster.codetestapp.ui.theme.TransparentWhite
import com.globallogic.core.domain.model.DeliveryWindow

@Composable
fun DeliveryWindowSelection(
    morning: DeliveryWindow?,
    afternoon: DeliveryWindow?,
    selectedWindow: Int,
    onOrderWindowClicked: (Int) -> Unit
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        SectionTitle(
            title = "Time of day",
            subtitle = "when would you like the fuel to be delivered",
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.weight(1f)) {
                morning?.let {
                    OrderWindowCard(
                        id = morning.id,
                        windowName = morning.rangeName,
                        windowRange = "${morning.startTime} - ${morning.endTime}",
                        selected = selectedWindow == morning.id,
                        onSelected = { onOrderWindowClicked(morning.id) },
                        modifier = Modifier.padding(end = 4.dp),
                    )
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                afternoon?.let {
                    OrderWindowCard(
                        id = afternoon.id,
                        windowName = afternoon.rangeName,
                        windowRange = "${afternoon.startTime} - ${afternoon.endTime}",
                        selected = selectedWindow == afternoon.id,
                        onSelected = { onOrderWindowClicked(afternoon.id) },
                        modifier = Modifier.padding(start = 4.dp),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderWindowCard(
    id: Int,
    windowName: String,
    windowRange: String,
    selected: Boolean,
    onSelected: (Int) -> Unit,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(28.dp),
        onClick = { onSelected(id) },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = 4.dp
    ) {
        Box(
            modifier = Modifier
                .background(
                    when (selected) {
                        true -> Brush.horizontalGradient(
                            listOf(
                                Purple200,
                                Purple700
                            )
                        )
                        false -> Brush.horizontalGradient(
                            listOf(
                                Color.LightGray,
                                Color.LightGray
                            )
                        )
                    }
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = windowName,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = if (selected) Color.White else Color.DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = windowRange,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = if (selected) TransparentWhite else Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OrderWindowUnselected() {
    BoosterCodeTestTheme {
        OrderWindowCard(
            id = 0,
            windowName = "Morning",
            windowRange = "7AM - 12PM",
            selected = false,
            onSelected = {},
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderWindowSelected() {
    BoosterCodeTestTheme {
        OrderWindowCard(
            id = 0,
            windowName = "Morning",
            windowRange = "7AM - 12PM",
            selected = true,
            onSelected = {},
            modifier = Modifier.padding(8.dp)
        )
    }
}
