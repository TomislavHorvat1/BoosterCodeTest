package com.globallogic.core.data

import com.globallogic.core.domain.model.BoostOrder

class BoosterDataRepository(
    private val localDataSource: BoosterDataSource,
) : BoosterDataSource {
    override fun getActiveOrder(): BoostOrder = localDataSource.getActiveOrder()
}
