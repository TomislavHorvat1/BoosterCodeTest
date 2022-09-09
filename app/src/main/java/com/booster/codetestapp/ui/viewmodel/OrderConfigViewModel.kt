package com.booster.codetestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.globallogic.core.domain.model.DeliveryWindow
import com.globallogic.core.domain.model.PaymentMethod
import com.globallogic.core.domain.model.PaymentMethodType

class OrderConfigViewModel : ViewModel() {
    private val _deliveryWindows = MutableLiveData<List<DeliveryWindow>>()
    val deliveryWindows: LiveData<List<DeliveryWindow>> = _deliveryWindows
    private val _selectedOrderWindow = MutableLiveData<Int>()
    val selectedOrderWindow: LiveData<Int> = _selectedOrderWindow
    private val _userPaymentMethods = MutableLiveData<List<PaymentMethod>>(listOf())
    val userPaymentMethods: LiveData<List<PaymentMethod>> = _userPaymentMethods
    private val _selectedPaymentMethod = MutableLiveData<Int>()
    val selectedPaymentMethod: LiveData<Int> = _selectedPaymentMethod
    private val _isPlaceOrderButtonEnabled = MutableLiveData(false)
    val isPlaceOrderButtonEnabled: LiveData<Boolean> = _isPlaceOrderButtonEnabled

    init {
        _deliveryWindows.value = listOf(
            DeliveryWindow(
                id = 0,
                rangeName = "Morning",
                startTime = "7AM",
                endTime = "12PM",
            ),
            DeliveryWindow(
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

    fun onDeliveryWindowClicked(deliveryWindowId: Int) {
        _selectedOrderWindow.value = deliveryWindowId
        _isPlaceOrderButtonEnabled.value = _selectedPaymentMethod.value?.let { it > -1 } ?: false
    }

    fun onPaymentTypeSelected(paymentMethodId: Int) {
        _selectedPaymentMethod.value = paymentMethodId
        _isPlaceOrderButtonEnabled.value = _selectedOrderWindow.value?.let { it > -1 } ?: false
    }

    fun onPlaceOrder(){

    }
}
