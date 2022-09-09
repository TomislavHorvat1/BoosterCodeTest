package com.booster.codetestapp.framework.provider

import android.content.Context
import android.content.SharedPreferences
import com.booster.codetestapp.framework.adapter.BoostOrderJsonAdapter
import com.globallogic.core.domain.model.BoostOrder

class PrefersManager(
    context: Context,
    private val adapter: BoostOrderJsonAdapter,
) {

    companion object {
        private const val DATA = "data"
        private const val ACTIVE_ORDER = "active_order"
    }

    private val prefs: SharedPreferences =
        context.getSharedPreferences(
            ACTIVE_ORDER,
            Context.MODE_PRIVATE,
        )

    var activeOrder: BoostOrder?
        get() = adapter.fromJson(prefs.getString(DATA, null))
        set(value) = prefs
            .edit()
            .putString(
                DATA,
                value?.let {
                    adapter.toJson(it)
                })
            .apply()
}