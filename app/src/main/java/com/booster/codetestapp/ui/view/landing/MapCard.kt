package com.booster.codetestapp.ui.view.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapCard(modifier: Modifier) {
    val sanFrancisco = LatLng(37.7592212, -122.418432757)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(sanFrancisco, 18.5f)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Card(elevation = 0.dp) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                uiSettings = MapUiSettings(
                    compassEnabled = false,
                    mapToolbarEnabled = false,
                    myLocationButtonEnabled = false,
                    zoomControlsEnabled = false,
                ),
                properties = MapProperties(mapType = MapType.SATELLITE),
                cameraPositionState = cameraPositionState
            ) { }
            MapHeader(modifier = Modifier.align(Alignment.TopStart))
            CarPin(modifier = Modifier.align(Alignment.Center))
            MapControlButtonHolder(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )
        }
    }
}
