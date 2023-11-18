package com.example.dogbreed.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dogbreed.viewmodel.MyViewModel
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: MyViewModel = viewModel()
) {
        val searchQuery by searchViewModel.message
    val dogPic = searchViewModel.dogPic.collectAsState()

    Scaffold(
        topBar = {
            SearchWidget(
                text = searchQuery,
                onTextChange = {
                               searchViewModel.updateSearchQuery(breed = it.lowercase(Locale.ROOT))

                },
                onSearchClicked = {
                    searchViewModel.searchHero(breed = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            ListContentScreen(items = dogPic.value)
        }
    )
}

