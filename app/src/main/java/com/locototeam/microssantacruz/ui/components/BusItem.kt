package com.locototeam.microssantacruz.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme

@Composable
fun BusItem(
    busName: String,
    isFavorite: Boolean,
    shouldShowArrow: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .height(46.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isFavorite) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star icon",
                tint = Color.Yellow,
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Card(
                modifier = Modifier
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.DirectionsBus,
                        contentDescription = "Bus icon"
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(
                        text = busName,
                    )
                }
            }
        }
        if (shouldShowArrow) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Bus icon"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BusItemPreview() {
    MicrosSantaCruzTheme {
        BusItem(
            busName = "Bus 1",
            isFavorite = true,
            shouldShowArrow = true,
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth(),
        )
    }
}