package com.booster.codetestapp.ui.view.orderconfig

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payment
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.theme.Purple200
import com.booster.codetestapp.ui.theme.Purple700
import com.globallogic.core.domain.model.PaymentMethod
import com.globallogic.core.domain.model.PaymentMethodType

@Composable
fun PaymentMethodSection(
    paymentMethods: List<PaymentMethod>,
    modifier: Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    var selected = paymentMethods[selectedIndex]

    Column(
        modifier = modifier.padding(8.dp)
    ) {
        SectionTitle(
            title = "Payment method",
            subtitle = "Tap to select a different payment method",
        )
        Card(
            backgroundColor = Color.LightGray,
            elevation = 4.dp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .clickable { expanded = !expanded }) {
            CardInfoLayout(
                name = selected.name ?: "",
                cardNumber = selected.value,
                type = selected.type,
                selected = true,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                offset = DpOffset(8.dp, 4.dp),
            ) {
                paymentMethods.forEachIndexed { i, paymentMethod ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        selectedIndex = i
                        selected = paymentMethod
                    }) {
                        CardInfoLayout(
                            name = paymentMethod.name ?: "",
                            cardNumber = paymentMethod.value,
                            type = paymentMethod.type,
                            selected = i == selectedIndex
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardInfoLayout(
    name: String,
    cardNumber: String,
    type: PaymentMethodType,
    selected: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Payment,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .align(CenterVertically),
            tint = Color.DarkGray
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "${type.name} - $name",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
            )
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = 0.dp,
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    if (selected) Purple200 else Color.LightGray,
                                    if (selected) Purple700 else Color.LightGray,
                                )
                            )
                        ),
                ) {
                    Text(
                        text = cardNumber,
                        color = if (selected) Color.White else Color.DarkGray,
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
fun CardInfoPreview() {
    BoosterCodeTestTheme {
        CardInfoLayout(
            name = "Erste",
            cardNumber = "XXXX XXXX XXXX 1234",
            type = PaymentMethodType.VISA,
            selected = true,
        )
    }
}
