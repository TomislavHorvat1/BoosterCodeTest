package com.booster.codetestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.globallogic.core.domain.model.Fuel
import com.globallogic.core.domain.model.FuelPrice

class LandingScreenViewModel : ViewModel() {
    private val _fuelPrice = MutableLiveData(
        FuelPrice(
            regular = Fuel(
                name = "Regular 87",
                currency = "$",
                price = 2.4,
            ),
            premium = Fuel(
                name = "Premium 91",
                currency = "$",
                price = 2.8,
            )
        )
    )
    val fuelPrice: LiveData<FuelPrice>
        get() = _fuelPrice
}