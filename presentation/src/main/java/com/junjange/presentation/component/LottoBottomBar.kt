package com.junjange.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.junjange.presentation.ui.main.Destination
import com.junjange.presentation.ui.theme.LottoTheme

@Composable
fun LottoBottomBar(
    currentDestination: NavDestination?,
    onNavigate: (Destination) -> Unit,
    navigateToActivity: () -> Unit,
) {
    Column {
        Spacer(
            modifier =
                Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = LottoTheme.colors.gray400),
        )

        NavigationBar {
            Destination.values().forEach { destination ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true

                NavigationBarItem(
                    icon = {
                        Image(
                            painter = painterResource(id = if (selected) destination.selectedIconRes else destination.inSelectedIconRes),
                            contentDescription = null,
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = destination.labelResId),
                            style =
                                MaterialTheme.typography.labelSmall.copy(
                                    color = if (selected) LottoTheme.colors.black else LottoTheme.colors.gray400,
                                ),
                        )
                    },
                    selected = false,
                    onClick = {
                        if (destination == Destination.RANDOM_NUMBER) {
                            navigateToActivity()
                        } else {
                            onNavigate(destination)
                        }
                    },
                    interactionSource = MutableInteractionSource(),
                )
            }
        }
    }
}
