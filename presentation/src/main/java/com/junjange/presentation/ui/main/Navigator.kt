package com.junjange.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

class Navigator(
    private val navController: NavController,
) {
    fun navigateTo(destination: Destination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberNavigator(navController: NavController) = remember(navController) { Navigator(navController) }
