package com.booster.codetestapp.framework.di

import com.booster.codetestapp.framework.adapter.BoostOrderJsonAdapter
import com.booster.codetestapp.framework.datasource.MockDataSource
import com.booster.codetestapp.framework.provider.MoshiProvider
import com.booster.codetestapp.framework.provider.PrefersManager
import com.booster.codetestapp.ui.viewmodel.DeliveryProgressViewModel
import com.booster.codetestapp.ui.viewmodel.LandingScreenViewModel
import com.booster.codetestapp.ui.viewmodel.OrderConfigViewModel
import com.globallogic.core.data.BoosterDataRepository
import com.globallogic.core.data.BoosterDataSource
import com.globallogic.core.usecase.GetOrder
import com.globallogic.core.usecase.PlaceOrder
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
    single { MockDataSource(prefsManager = get()) }
    single<BoosterDataSource> { BoosterDataRepository(localDataSource = get<MockDataSource>()) }

    single { PlaceOrder(dataSource = get()) }
    single { GetOrder(dataSource = get()) }

    viewModel { LandingScreenViewModel() }
    viewModel { OrderConfigViewModel(placeOrder = get()) }
    viewModel { DeliveryProgressViewModel(get()) }
}
