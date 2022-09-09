package com.booster.codetestapp.framework.datasource

import com.booster.codetestapp.framework.provider.PrefersManager
import com.globallogic.core.data.BoosterDataSource
import com.globallogic.core.domain.model.BoostOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockDataSource(
    private val prefsManager: PrefersManager
) : BoosterDataSource {
    override fun setActiveOrder(order: BoostOrder): Flow<BoostOrder> = flow {
        prefsManager.activeOrder = order
        emit(order)
    }

    override fun getActiveOrder(): Flow<BoostOrder?> = flow {
        emit(prefsManager.activeOrder)
    }
}