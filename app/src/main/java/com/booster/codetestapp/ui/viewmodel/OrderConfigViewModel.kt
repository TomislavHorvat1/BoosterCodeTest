package com.booster.codetestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globallogic.core.data.OrderStatus
import com.globallogic.core.domain.model.BoostOrder
import com.globallogic.core.domain.model.DeliveryWindow
import com.globallogic.core.domain.model.PaymentMethod
import com.globallogic.core.domain.model.PaymentMethodType
import com.globallogic.core.usecase.PlaceOrder
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class OrderConfigViewModel(private val placeOrder: PlaceOrder) : ViewModel() {
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
    private val _orderStatus = MutableLiveData<OrderStatus>()
    val orderStatus: LiveData<OrderStatus> = _orderStatus

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
        _orderStatus.value = null
    }

    fun onPaymentTypeSelected(paymentMethodId: Int) {
        _selectedPaymentMethod.value = paymentMethodId
        _isPlaceOrderButtonEnabled.value = _selectedOrderWindow.value?.let { it > -1 } ?: false
        _orderStatus.value = null
    }

    fun onPlaceOrder() {
        when (isPlaceOrderButtonEnabled.value) {
            true -> {
                val order = BoostOrder(
                    deliveryWindow = deliveryWindows.value!![selectedOrderWindow.value!!],
                    paymentMethod = userPaymentMethods.value!![selectedPaymentMethod.value!!]
                )
                viewModelScope.launch {
                    placeOrder.invoke(order)
                        .catch { Timber.e(it.message) }
                        .collect {
                            _orderStatus.value = OrderStatus(
                                order = it
                            )
                        }
                }
            }
            else -> _orderStatus.value = OrderStatus(
                error = Throwable("Please select all required fields")
            )
        }
    }
}
