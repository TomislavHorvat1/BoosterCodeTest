package com.globallogic.core.data

import com.globallogic.core.domain.model.BoostOrder

class OrderStatus(
    val order: BoostOrder? = null,
    val error: Throwable? = null
)