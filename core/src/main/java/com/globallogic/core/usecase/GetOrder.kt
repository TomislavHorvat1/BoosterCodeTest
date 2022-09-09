package com.globallogic.core.usecase

import com.globallogic.core.data.BoosterDataSource
import com.globallogic.core.domain.model.BoostOrder
import kotlinx.coroutines.flow.Flow

class GetOrder(private val dataSource: BoosterDataSource) {
    suspend operator fun invoke(): Flow<BoostOrder?> = dataSource.getActiveOrder()
}