package com.infinitelearning.appxample.ui.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("home")
    data object Profile: Screen("profile")
    data object ChatBot: Screen("chatbot")
}