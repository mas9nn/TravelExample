package com.example.travelexample.presentation.util

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelexample.presentation.intro.IntroScreen
import com.example.travelexample.presentation.main.MainScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.IntroScreen.route
    ) {
        composable(Screen.IntroScreen.route) {
            IntroScreen(navController = navController)
        }
        composable(Screen.MainScreen.route) {
            MainScreen()
        }
    }
}