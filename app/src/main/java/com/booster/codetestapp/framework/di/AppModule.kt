package com.booster.codetestapp.di

import com.booster.codetestapp.adapter.BoostOrderJsonAdapter
import com.booster.codetestapp.framework.provider.MoshiProvider
import com.booster.codetestapp.framework.provider.PrefersManager
import com.booster.codetestapp.ui.viewmodel.DeliveryProgressViewModel
import com.booster.codetestapp.ui.viewmodel.LandingScreenViewModel
import com.booster.codetestapp.ui.viewmodel.OrderConfigViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MoshiProvider.build() }
    single { BoostOrderJsonAdapter(get()) }
    single {
        PrefersManager(
            context = get(),
            adapter = get(),
        )
    }

    viewModel { LandingScreenViewModel() }
    viewModel { OrderConfigViewModel() }
    viewModel { DeliveryProgressViewModel() }
}
