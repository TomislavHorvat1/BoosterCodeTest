package com.booster.codetestapp.ui.view.deliveryProgress

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.ui.view.landing.GradientButton
import com.booster.codetestapp.ui.viewmodel.DeliveryProgressViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DeliveryProgressScreen(onCancel: () -> Unit) {
    val viewModel: DeliveryProgressViewModel = getViewModel()
    val selectedWindow = viewModel.selectedDeliveryWindow.observeAsState().value
    val selectedPaymentMethod = viewModel.selectedPaymentMethod.observeAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp
            ) { Toolbar(onBack = onCancel) }
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BackHandler(
                enabled = true,
                onBack = onCancel,
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                selectedWindow?.let {
                    SelectedOptionWindow(
                        label = "Selected delivery time",
                        name = selectedWindow.rangeName,
                        value = "${selectedWindow.startTime} - ${selectedWindow.endTime}",
                    )
                }
                Divider()
                selectedPaymentMethod?.let {
                    val cardName = selectedPaymentMethod.type
                    SelectedOptionWindow(
                        label = "Selected payment method",
                        name = selectedPaymentMethod.name?.let { "$cardName - it" }
                            ?: "$cardName",
                        value = selectedPaymentMethod.value,
                        modifier = Modifier.weight(1f)
                    )
                }
                GradientButton(
                    text = "Cancel Boost",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = onCancel,
                    enabled = true
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
            modifier = Modifier.align(Alignment.CenterVertically),
        ) {
            Icon(Icons.Filled.ArrowBack, null)
        }
        Text(
            text = "Request in progress",
            modifier = Modifier.align(Alignment.CenterVertically),
            style = MaterialTheme.typography.body1,
        )
    }
}
