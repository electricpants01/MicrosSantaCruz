package com.locototeam.microssantacruz.ui.view.bottomNav

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigationBar(
    selectedItemIndex: Int,
    onSelectedItemIndexChange: (Int) -> Unit
) {
    NavigationBar {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                icon = {
                    BadgedBox(badge = {
                        // no badge
                    }) {
                        Icon(
                            imageVector = if (selectedItemIndex == index) {
                                bottomNavItem.selectedIcon
                            } else {
                                bottomNavItem.unselectedIcon
                            },
                            contentDescription = stringResource(id = bottomNavItem.label)
                        )

                    }
                },
                onClick = {
                    onSelectedItemIndexChange(index)
                },
                alwaysShowLabel = true,
                label = {
                    Text(
                        stringResource(id = bottomNavItem.label)
                    )
                },
                selected = selectedItemIndex == index
            )
        }
    }
}