package com.booster.codetestapp.framework.adapter

import com.globallogic.core.domain.model.BoostOrder
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class BoostOrderJsonAdapter(moshi: Moshi) {

    private val adapter: JsonAdapter<BoostOrder> = moshi.adapter(BoostOrder::class.java)

    fun toJson(boosterOrder: BoostOrder): String = adapter.toJson(boosterOrder)

    fun fromJson(jsonString: String?): BoostOrder? = jsonString?.let { adapter.fromJson(it) }
}