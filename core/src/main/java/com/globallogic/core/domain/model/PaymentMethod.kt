package com.globallogic.core.domain.model

data class PaymentMethod(
    val name: String?,
    val value: String,
    val type: PaymentMethodType,
)
