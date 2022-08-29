package com.booster.codetestapp.di

import com.booster.codetestapp.data.adapter.BoostOrderJsonAdapter
import com.booster.codetestapp.data.provider.MoshiProvider
import com.booster.codetestapp.data.provider.PreferencesProvider
import org.koin.dsl.module

val appModule = module {
    single { MoshiProvider.build() }
    single { BoostOrderJsonAdapter(get()) }
    single {
        PreferencesProvider(
            context = get(),
            adapter = get(),
        )
    }
}