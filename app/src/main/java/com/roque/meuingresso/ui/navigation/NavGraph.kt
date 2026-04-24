package com.roque.meuingresso.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roque.meuingresso.ui.features.movielist.MovieListScreen

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route
    ) {
        composable(Screen.MovieList.route) {
            MovieListScreen()
        }
    }
}