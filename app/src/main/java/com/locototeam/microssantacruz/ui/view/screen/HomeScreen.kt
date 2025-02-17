
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme
import com.locototeam.microssantacruz.ui.view.components.FavoriteModel
import com.locototeam.microssantacruz.ui.view.components.FavoritesComposable
import com.locototeam.microssantacruz.ui.view.components.FrequentLinesComposable
import com.locototeam.microssantacruz.ui.view.components.RecentModel
import com.locototeam.microssantacruz.ui.view.components.RecentTripsComposable
import com.locototeam.microssantacruz.ui.view.components.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn (
        modifier = modifier,
    ) {
        item {
            // Search bar
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                SearchBar(
                    query = "",
                    onQueryChange = {},
                    onSearch = {},
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
        item {
            // Frequent lines
            FrequentLinesComposable(
                lines = listOf("Line 1", "Line 2", "Line 3"),
                modifier = Modifier.padding(8.dp)
            )
        }
        item {
            // Favorites
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
                modifier = Modifier.padding(8.dp)
            )
        }
        item {
            // Recent trips
            RecentTripsComposable(
                recentList = listOf(
                    RecentModel(
                        name = "Recent 1",
                        description = "Description 1",
                    ),
                    RecentModel(
                        name = "Recent 2",
                        description = "Description 2",
                    ),
                    RecentModel(
                        name = "Recent 3",
                        description = "Description 3",
                    ),
                ),
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    MicrosSantaCruzTheme {
        HomeScreen()
    }
}