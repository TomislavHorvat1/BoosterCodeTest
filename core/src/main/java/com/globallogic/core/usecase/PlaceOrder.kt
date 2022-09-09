package com.globallogic.core.usecase

import com.globallogic.core.data.BoosterDataSource
import com.globallogic.core.domain.model.BoostOrder

class PlaceOrder(private val dataSource: BoosterDataSource) {
    suspend operator fun invoke(order: BoostOrder) = dataSource.setActiveOrder(order)
}