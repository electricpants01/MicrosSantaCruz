package com.locototeam.microssantacruz

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.locototeam.microssantacruz.ui.theme.MicrosSantaCruzTheme
import com.locototeam.microssantacruz.ui.view.bottomNav.BottomNavigationBar
import com.locototeam.microssantacruz.ui.view.bottomNav.bottomNavItems
import com.locototeam.microssantacruz.ui.view.screen.BusListScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    companion object {
        private const val ARG_NAVIGATION_DIRECTION = "directions"
        private const val ARG_NAVIGATION_MICROS = "micros"
    }
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectedItemIndex by rememberSaveable {
                mutableIntStateOf(0)
            }
            val navController = rememberNavController()
            MicrosSantaCruzTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet { /* Drawer content */ }
                    },
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text("My App") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            if (drawerState.isClosed) {
                                                drawerState.open()
                                            } else {
                                                drawerState.close()
                                            }
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Open Drawer"
                                        )
                                    }
                                }
                            )
                        },
                        bottomBar = {
                            BottomNavigationBar(
                                selectedItemIndex = selectedItemIndex,
                            ) {
                                selectedItemIndex = it
                                navController.navigate(bottomNavItems[it].route)
                            }
                        },
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                text = { Text("Show drawer") },
                                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                                onClick = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                            )
                        }
                    ) { contentPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = ARG_NAVIGATION_MICROS,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(contentPadding)
                        ) {
                            composable(ARG_NAVIGATION_DIRECTION) {
                                HomeScreen()
                            }
                            composable(ARG_NAVIGATION_MICROS) {
                                BusListScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}