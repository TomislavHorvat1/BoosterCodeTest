package com.booster.codetestapp.di

import com.booster.codetestapp.data.adapter.BoostOrderJsonAdapter
import com.booster.codetestapp.data.provider.MoshiProvider
import com.booster.codetestapp.data.provider.PreferencesProvider
import com.booster.codetestapp.ui.viewmodel.LandingScreenViewModel
import com.booster.codetestapp.ui.viewmodel.OrderConfigViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
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

    viewModel { LandingScreenViewModel() }
    viewModel { OrderConfigViewModel() }
}