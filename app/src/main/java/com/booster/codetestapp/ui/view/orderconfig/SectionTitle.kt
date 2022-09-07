package com.booster.codetestapp.ui.view.orderconfig

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.booster.codetestapp.ui.theme.BoosterCodeTestTheme
import java.util.*

@Composable
fun SectionTitle(
    title: String,
    subtitle: String,
) {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {
        Text(
            text = title.uppercase(Locale.getDefault()),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )
        Text(
            text = subtitle.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Light,
            fontSize = 11.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    bottom = 8.dp,
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SectionTitlePreview() {
    BoosterCodeTestTheme {
        SectionTitle(
            title = "delivery time",
            subtitle = "select when would you like the delivery to come",
        )
    }
}
