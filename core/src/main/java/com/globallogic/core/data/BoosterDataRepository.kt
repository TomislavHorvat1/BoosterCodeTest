package com.globallogic.core.data

import com.globallogic.core.domain.model.BoostOrder
import kotlinx.coroutines.flow.Flow

class BoosterDataRepository(
    private val localDataSource: BoosterDataSource,
) : BoosterDataSource {
    override fun setActiveOrder(order: BoostOrder) = localDataSource.setActiveOrder(order = order)

    override fun getActiveOrder(): Flow<BoostOrder?> = localDataSource.getActiveOrder()
}
