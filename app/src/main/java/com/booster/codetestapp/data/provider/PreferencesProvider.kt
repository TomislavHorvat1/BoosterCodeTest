package com.booster.codetestapp.data.provider

import android.content.Context
import android.content.SharedPreferences
import com.booster.codetestapp.data.adapter.BoostOrderJsonAdapter
import com.booster.codetestapp.data.model.BoostOrder

class PreferencesProvider(
    context: Context,
    private val adapter: BoostOrderJsonAdapter,
) {

    companion object {
        private const val ORDER = "order"
        private const val ACTIVE_ORDER = "active_order"
    }

    private val prefs: SharedPreferences =
        context.getSharedPreferences(
            ORDER,
            Context.MODE_PRIVATE,
        )

    var activeOrder: BoostOrder?
        get() = adapter.fromJson(prefs.getString(ACTIVE_ORDER, null))
        set(value) = prefs
            .edit()
            .putString(
                ACTIVE_ORDER,
                value?.let {
                    adapter.toJson(it)
                })
            .apply()
}