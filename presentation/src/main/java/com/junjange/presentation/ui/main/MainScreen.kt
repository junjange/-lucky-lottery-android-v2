package com.junjange.presentation.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.junjange.presentation.component.LottoBottomBar
import com.junjange.presentation.ui.home.HomeScreen
import com.junjange.presentation.ui.my.MyNumberScreen
import com.junjange.presentation.ui.mynumber.MyScreen

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navigateToRandomNumber: () -> Unit,
) {

    val navController = rememberNavController()
    val navigator = rememberNavigator(navController = navController)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            LottoBottomBar(
                currentDestination = currentDestination,
                onNavigate = { navigator.navigateTo(it) },
                navigateToActivity = navigateToRandomNumber
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destination.HOME.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destination.HOME.route) { HomeScreen() }
            composable(Destination.MY_NUMBER.route) { MyNumberScreen() }
            composable(Destination.MY.route) { MyScreen() }
        }
    }
}