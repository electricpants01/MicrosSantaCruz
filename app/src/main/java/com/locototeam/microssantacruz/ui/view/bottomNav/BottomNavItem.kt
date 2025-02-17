package com.locototeam.microssantacruz.ui.view.bottomNav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.LinearScale
import androidx.compose.material.icons.outlined.DirectionsBus
import androidx.compose.material.icons.outlined.LinearScale
import androidx.compose.ui.graphics.vector.ImageVector
import com.locototeam.microssantacruz.R

internal sealed class BottomNavItem(
    val route: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    @StringRes val label: Int,
) {
    object Directions : BottomNavItem("directions", Icons.Outlined.LinearScale, Icons.Filled.LinearScale, R.string.directions)
    object Micros : BottomNavItem("micros", Icons.Outlined.DirectionsBus, Icons.Filled.DirectionsBus, R.string.micros)
}

internal val bottomNavItems = listOf(
    BottomNavItem.Directions,
    BottomNavItem.Micros,
)