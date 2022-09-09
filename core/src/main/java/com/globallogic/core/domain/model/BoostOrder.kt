package com.globallogic.core.domain.model

data class BoostOrder(
    val deliveryWindow: DeliveryWindow,
    val paymentMethod: PaymentMethod,
)
