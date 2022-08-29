package com.booster.codetestapp.data.adapter

import com.booster.codetestapp.data.model.BoostOrder
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class BoostOrderJsonAdapter(moshi: Moshi) {

    private val adapter: JsonAdapter<BoostOrder> = moshi.adapter(BoostOrder::class.java)

    fun toJson(boosterOrder: BoostOrder): String = adapter.toJson(boosterOrder)

    fun fromJson(jsonString: String?): BoostOrder? = jsonString?.let { adapter.fromJson(it) }
}