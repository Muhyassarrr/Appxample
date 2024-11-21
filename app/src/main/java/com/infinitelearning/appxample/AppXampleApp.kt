package com.infinitelearning.appxample

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.infinitelearning.appxample.ui.navigation.CustomBottomBar
import com.infinitelearning.appxample.ui.navigation.Screen
import com.infinitelearning.appxample.ui.screen.chatbot.ChatBotScreen
import com.infinitelearning.appxample.ui.screen.home.HomeScreen
import com.infinitelearning.appxample.ui.screen.profile.ProfileScreen
import com.infinitelearning.appxample.utils.shouldShowBottomBar
import com.infinitelearning.appxample.utils.shouldShowFloatingActionBar

@Composable
fun AppXampleApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = currentRoute.shouldShowBottomBar()) {
                CustomBottomBar(
                    navHostController
                )
            }
        },
        floatingActionButton = {
            AnimatedVisibility(visible = currentRoute.shouldShowFloatingActionBar()) {
                FloatingActionButton(
                    onClick = {
                        navHostController.navigate(Screen.ChatBot.route)
                    }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Icon Add")
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(Screen.ChatBot.route) {
                ChatBotScreen()
            }
        }
    }
}