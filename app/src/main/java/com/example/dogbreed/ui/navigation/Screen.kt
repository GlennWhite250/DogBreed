package com.example.dogbreed.ui.navigation

import com.example.dogbreed.util.Constants.SEARCH_SCREEN

sealed class Screen(val route: String) {
    object Search: Screen(SEARCH_SCREEN)
}
