package com.globallogic.core.domain.model

import java.sql.Date

data class OrderWindow(
    val id: Int,
    val rangeName: String,
    val startTime: String,
    val endTime: String,
)
