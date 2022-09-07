package com.globallogic.core.data

import com.globallogic.core.domain.model.BoostOrder

interface BoosterDataSource {
    fun getActiveOrder(): BoostOrder
}
