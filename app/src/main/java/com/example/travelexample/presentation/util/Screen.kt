package com.example.travelexample.presentation.util

sealed class Screen(val route:String) {
    object IntroScreen:Screen("intro_screen")
    object MainScreen:Screen("main_screen")
}