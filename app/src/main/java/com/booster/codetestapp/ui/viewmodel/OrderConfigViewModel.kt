package com.booster.codetestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.globallogic.core.domain.model.OrderWindow
import com.globallogic.core.domain.model.PaymentMethod
import com.globallogic.core.domain.model.PaymentMethodType

class OrderConfigViewModel : ViewModel() {
    private val _orderWindows = MutableLiveData<List<OrderWindow>>()
    val orderWindows: LiveData<List<OrderWindow>> = _orderWindows
    private val _selectedOrderWindows = MutableLiveData<List<Int>>(listOf())
    val selectedOrderWindows: LiveData<List<Int>> = _selectedOrderWindows
    private val _userPaymentMethods = MutableLiveData<List<PaymentMethod>>(listOf())
    val userPaymentMethods: LiveData<List<PaymentMethod>> = _userPaymentMethods

    init {
        _orderWindows.value = listOf(
            OrderWindow(
                id = 0,
                rangeName = "Morning",
                startTime = "7AM",
                endTime = "12PM",
            ),
            OrderWindow(
                id = 1,
                rangeName = "Afternoon",
                startTime = "1PM",
                endTime = "6PM",
            ),
        )

        _userPaymentMethods.value = listOf(
            PaymentMethod(
                name = "Erste",
                value = "XXXX XXXX XXXX 1234",
                type = PaymentMethodType.VISA,
            ),
            PaymentMethod(
                name = null,
                value = "XXXX XXXX XXXX 9999",
                type = PaymentMethodType.MASTERCARD,
            ),
            PaymentMethod(
                name = "Intessa Bank",
                value = "XXXX XXXX XXXX 9876",
                type = PaymentMethodType.AMEX,
            ),
        )
    }

    fun onOrderWindowClicked(id: Int) {
        val newList = _selectedOrderWindows.value?.toMutableList() ?: mutableListOf()
        newList.removeIf { it == id }.let {
            if (!it) newList.add(id)
        }

        _selectedOrderWindows.value = newList.toList()
    }
}
