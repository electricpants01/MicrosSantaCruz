package com.locototeam.microssantacruz.ui.view.drawer

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.locototeam.microssantacruz.R
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme

@Composable
fun DrawerContent() {
    LazyColumn {
        item {
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.app_name)
            )
            HorizontalDivider(modifier = Modifier.padding(start = 16.dp))
        }
        DrawerItems.entries.forEach { item ->
            item {
                DrawerItem(
                    labelRes = item.labelRes,
                    imageVector = item.imageVector,
                    onClick = {}
                )
            }
        }
    }
}

@Composable
private fun DrawerItem(
    @StringRes labelRes: Int,
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
        )
        Text(
            text = stringResource(labelRes),
            modifier = Modifier.padding(16.dp)
        )
    }
}

private enum class DrawerItems(
    @StringRes val labelRes: Int,
    val imageVector: ImageVector
) {
    Settings(R.string.settings, Icons.Default.Settings),
    Share(R.string.share, Icons.Default.Share),
    RateUs(R.string.rate_us, Icons.Default.StarRate)
}

@PreviewLightDark
@Composable
fun DrawerContentPreview() {
    MicrosSantaCruzTheme {
        DrawerContent()
    }
}