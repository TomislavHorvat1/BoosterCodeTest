package com.globallogic.core.domain.model

data class DeliveryWindow(
    val id: Int,
    val rangeName: String,
    val startTime: String,
    val endTime: String,
)
