package com.booster.codetestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.globallogic.core.domain.model.DeliveryWindow
import com.globallogic.core.domain.model.PaymentMethod

class DeliveryProgressViewModel : ViewModel() {
    private val _selectedDeliveryWindow = MutableLiveData<DeliveryWindow?>()
    val selectedDeliveryWindow: LiveData<DeliveryWindow?> = _selectedDeliveryWindow
    private val _selectedPaymentMethod = MutableLiveData<PaymentMethod?>()
    val selectedPaymentMethod: LiveData<PaymentMethod?> = _selectedPaymentMethod
}
