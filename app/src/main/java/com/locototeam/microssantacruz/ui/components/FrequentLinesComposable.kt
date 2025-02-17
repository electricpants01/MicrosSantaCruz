package com.locototeam.microssantacruz.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme

@Composable
fun FrequentLinesComposable(
    lines: List<String>,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
        shape = RectangleShape,
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "My Frequent Lines",
            )
            HorizontalDivider()
            lines.map {
                BusItem(
                    busName = it,
                    isFavorite = true,
                    shouldShowArrow = true,
                    modifier = Modifier.padding(8.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun FrequentLinesComposablePreview() {
    MicrosSantaCruzTheme {
        FrequentLinesComposable(
            lines = listOf("Line 1", "Line 2", "Line 3")
        )
    }
}