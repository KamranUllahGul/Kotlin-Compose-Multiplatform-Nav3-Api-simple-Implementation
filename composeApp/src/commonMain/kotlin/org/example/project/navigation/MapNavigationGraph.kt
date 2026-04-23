package org.example.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.example.project.screens.MapViewScreen
import org.example.project.screens.mapview.MapDetailScreen
import org.example.project.screens.mapview.MapSettingsScreen

@Composable
fun MapNavigationGraph(
    onBackToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    // This backStack is local to the Map feature only
    val mapBackStack = rememberNavBackStack(
        configuration = appSavedStateConfiguration,
        elements = arrayOf(Screen.MapView)
    )

    NavDisplay(
        modifier = modifier,
        backStack = mapBackStack,
        onBack = {
            if (mapBackStack.size > 1) {
                mapBackStack.removeLastOrNull()
            } else {
                onBackToHome()
            }
        },
       /** transitionSpec = {
            slideInHorizontally { it } + fadeIn() togetherWith
                    slideOutHorizontally { -it } + fadeOut()
        },
        popTransitionSpec = {
            slideInHorizontally { -it } + fadeIn() togetherWith
                    slideOutHorizontally { it } + fadeOut()
        },*/

        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Screen.MapView> {
                MapViewScreen(
                    onBack = { if (mapBackStack.size > 1) {
                        mapBackStack.removeLastOrNull()
                    } else {
                        onBackToHome()
                    } },
                    onMapDetailClick = { mapBackStack.add(Screen.MapDetail) },
                    onMapSettingsClick = { mapBackStack.add(Screen.MapSettings) }
                )
            }
            entry<Screen.MapDetail> {
                MapDetailScreen(onBack = { mapBackStack.removeLastOrNull() })
            }
            entry<Screen.MapSettings> {
                MapSettingsScreen(onBack = { mapBackStack.removeLastOrNull() })
            }
        }
    )
}