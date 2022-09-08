package com.booster.codetestapp.ui.view.orderconfig

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import com.booster.codetestapp.ui.view.landing.GradientButton
import com.booster.codetestapp.ui.viewmodel.OrderConfigViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun OrderConfigurationScreen() {
    val viewModel: OrderConfigViewModel = getViewModel()
    val orderWindows = viewModel.orderWindows.observeAsState()
    val selectedWindow = viewModel.selectedOrderWindow.observeAsState()
    val userPaymentMethods = viewModel.userPaymentMethods.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp
            ) { Toolbar {/* TODO */ } }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                DeliveryWindowSelection(
                    morning = orderWindows.value?.get(0),
                    afternoon = orderWindows.value?.get(1),
                    selectedWindow = selectedWindow.value ?: -1,
                    onOrderWindowClicked = { id ->
                        viewModel.onOrderWindowClicked(id)
                    }
                )
                Divider()
                PaymentMethodSection(
                    paymentMethods = userPaymentMethods.value ?: listOf(),
                    modifier = Modifier.weight(1f)
                )
                GradientButton(
                    text = "Order a Boost",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = { /*TODO*/ },
                    enabled = selectedWindow.value?.let { it > -1 } ?: false
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
            onClick = { onBack() },
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
