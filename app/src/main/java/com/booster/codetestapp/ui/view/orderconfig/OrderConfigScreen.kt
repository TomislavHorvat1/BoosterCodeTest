package com.booster.codetestapp.ui.view.orderconfig

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.view.landing.GradientButton
import com.booster.codetestapp.ui.viewmodel.OrderConfigViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun OrderConfigurationScreen(
    onPlaceOrderClick: () -> Unit,
    onBack: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val viewModel: OrderConfigViewModel = getViewModel()
    val deliveryWindows = viewModel.deliveryWindows.observeAsState()
    val selectedWindow = viewModel.selectedOrderWindow.observeAsState()
    val userPaymentMethods = viewModel.userPaymentMethods.observeAsState()
    val selectedPaymentMethod = viewModel.selectedPaymentMethod.observeAsState()
    val isPlaceOrderButtonEnabled = viewModel.isPlaceOrderButtonEnabled.observeAsState()
    val orderStatus = viewModel.orderStatus.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp
            ) { Toolbar(onBack = onBack) }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    DeliveryWindowSelection(
                        morning = deliveryWindows.value?.get(0),
                        afternoon = deliveryWindows.value?.get(1),
                        selectedWindow = selectedWindow.value ?: -1,
                        onOrderWindowClicked = { id ->
                            viewModel.onDeliveryWindowClicked(id)
                        }
                    )
                    Divider()
                    PaymentMethodSection(
                        paymentMethods = userPaymentMethods.value ?: listOf(),
                        selectedPaymentMethod = selectedPaymentMethod.value ?: -1,
                        onSelectedPaymentMethod = { viewModel.onPaymentTypeSelected(it) },
                        modifier = Modifier.weight(1f),
                    )
                    GradientButton(
                        text = "Order a Boost",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        onClick = {
                            viewModel.onPlaceOrder()
                            orderStatus
                                .value
                                ?.order
                                ?.let {
                                    isPlaceOrderButtonEnabled
                                        .value
                                        ?.let {
                                            if (it) onPlaceOrderClick()
                                        }
                                }
                        },
                        enabled = isPlaceOrderButtonEnabled.value ?: false
                    )
                }
                orderStatus.value?.error?.let {
                    scope.launch {
                        snackBarHostState.showSnackbar(it.message ?: "Oops")
                    }
                }
                SnackbarHost(
                    modifier = Modifier.align(BottomCenter),
                    hostState = snackBarHostState,
                )
            }
        }
    }
}

@Composable
private fun Toolbar(onBack: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.align(CenterVertically),
        ) {
            Icon(Icons.Filled.ArrowBack, null)
        }
        Text(
            text = "Order configuration",
            modifier = Modifier.align(CenterVertically),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderConfigToolbarPreview() {
    BoosterCodeTestTheme {
        Toolbar {}
    }
}
