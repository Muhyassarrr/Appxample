package com.infinitelearning.appxample.utils

import com.infinitelearning.appxample.ui.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Profile.route
    )
}

fun String?.shouldShowFloatingActionBar(): Boolean {
    return this in setOf(
        Screen.Home.route
    )
}