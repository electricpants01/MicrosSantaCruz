package com.locototeam.microssantacruz.ui.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.locototeam.microssantacruz.R
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme

data class FavoriteModel(
    val name: String,
    val description: String,
)

@Composable
fun FavoritesComposable(
    favoriteList: List<FavoriteModel>,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        )
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(R.string.favorites),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(R.string.add),
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
            HorizontalDivider()

            favoriteList.map {
                var isMenuExpanded by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Icon(
                        modifier = Modifier.padding(8.dp),
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location icon",
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                    ) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = it.description,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                    IconButton(
                        onClick = { isMenuExpanded = true },
                    ) {
                        Icon(
                            modifier = Modifier.padding(8.dp),
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More icon",
                        )
                    }

                    // DropdownMenu
                    DropdownMenu(
                        expanded = isMenuExpanded,
                        onDismissRequest = { isMenuExpanded = false }, // Close the menu
                        modifier = Modifier.fillMaxWidth(0.5f), // Optional: Adjust width
                    ) {
                        DropdownMenuItem(
                            text = { Text("Remove Favorite") },
                            onClick = {
                                // Handle "Remove Favorite" action
                                isMenuExpanded = false // Close the menu
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Edit Favorite") },
                            onClick = {
                                // Handle "Edit Favorite" action
                                isMenuExpanded = false // Close the menu
                            }
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
fun FavoritesComposablePreview() {
    MicrosSantaCruzTheme {
        FavoritesComposable(
            favoriteList = listOf(
                FavoriteModel(
                    name = "Favorite 1",
                    description = "Description 1",
                ),
                FavoriteModel(
                    name = "Favorite 2",
                    description = "Description 2",
                ),
                FavoriteModel(
                    name = "Favorite 3",
                    description = "Description 3",
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}