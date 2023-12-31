package com.example.dogbreed.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dogbreed.ui.screen.ListContentScreen
import com.example.dogbreed.ui.screen.SearchScreen
import com.example.dogbreed.viewmodel.MyViewModel

@Composable
fun Navigation(){
    val navHostController = rememberNavController()
    val viewModel: MyViewModel = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = Screen.Search.route
    ){
        composable(Screen.Search.route) {
            SearchScreen(navController = navHostController)
        }
    }
}