package com.booster.codetestapp.ui.view.deliveryProgress

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.ui.view.orderconfig.CardInfoLayout
import com.booster.codetestapp.ui.view.orderconfig.SectionTitle
import com.globallogic.core.domain.model.PaymentMethod

@Composable
fun SelectedPaymentMethod(paymentMethod: PaymentMethod) {
    Column(modifier = Modifier.padding(8.dp)) {
        SectionTitle(title = "selected payment method")
        CardInfoLayout(
            name = paymentMethod.name ?: "",
            cardNumber = paymentMethod.value,
            type = paymentMethod.type,
            selected = true,
        )
    }
}
