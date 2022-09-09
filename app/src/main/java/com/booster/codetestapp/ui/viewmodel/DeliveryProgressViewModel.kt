package com.booster.codetestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globallogic.core.domain.model.DeliveryWindow
import com.globallogic.core.domain.model.PaymentMethod
import com.globallogic.core.usecase.GetOrder
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class DeliveryProgressViewModel(private val getOrder: GetOrder) : ViewModel() {
    private val _selectedDeliveryWindow = MutableLiveData<DeliveryWindow?>()
    val selectedDeliveryWindow: LiveData<DeliveryWindow?> = _selectedDeliveryWindow
    private val _selectedPaymentMethod = MutableLiveData<PaymentMethod?>()
    val selectedPaymentMethod: LiveData<PaymentMethod?> = _selectedPaymentMethod

    init {
        viewModelScope.launch {
            getOrder.invoke()
                .catch {
                    Timber.e(it.message)
                }
                .collect {
                    it?.let {
                        _selectedDeliveryWindow.value = it.deliveryWindow
                        _selectedPaymentMethod.value = it.paymentMethod
                    }
                }
        }
    }
}
