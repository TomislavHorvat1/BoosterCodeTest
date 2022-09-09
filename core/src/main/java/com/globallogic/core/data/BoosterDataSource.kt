package com.globallogic.core.data

import com.globallogic.core.domain.model.BoostOrder
import kotlinx.coroutines.flow.Flow

interface BoosterDataSource {
    fun setActiveOrder(order: BoostOrder): Flow<BoostOrder>
    fun getActiveOrder(): Flow<BoostOrder?>
}
