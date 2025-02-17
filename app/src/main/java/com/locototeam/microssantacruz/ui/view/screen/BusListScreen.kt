package com.locototeam.microssantacruz.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme
import com.locototeam.microssantacruz.ui.view.components.BusItem
import com.locototeam.microssantacruz.ui.view.components.SearchBar
import kotlinx.coroutines.launch

@Composable
fun BusListScreen(
    modifier: Modifier = Modifier,
) {
    // Tab titles
    val tabs = listOf("All", "Favorites")

    // State to track the selected tab
    val pagerState = rememberPagerState(
        pageCount = {
            tabs.size
        },
        initialPage = 0
    )

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Search bar (moved above the TabRow)
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

        // Tab Row
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        // Animate to the selected tab
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(title) }
                )
            }
        }

        // Horizontal Pager for swipeable content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> {
                    // "All" tab content
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(20) { index ->
                            BusItem(
                                busName = "Bus $index",
                                isFavorite = false,
                                shouldShowArrow = true,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
                1 -> {
                    // "Favorites" tab content
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(10) { index ->
                            BusItem(
                                busName = "Favorite Bus $index",
                                isFavorite = true,
                                shouldShowArrow = true,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BusListScreenPreview() {
    MicrosSantaCruzTheme {
        BusListScreen(modifier = Modifier.padding(top = 24.dp))
    }
}