package com.roque.meuingresso.ui.features.movielist.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roque.meuingresso.domain.model.Movie
import com.roque.meuingresso.ui.features.movielist.MovieListContract

@Composable
fun MovieListContent(
    state: MovieListContract.State,
    onMovieClick: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }
            state.error != null -> {
                Text(text = state.error, color = Color.Red, modifier = Modifier.padding(16.dp))
            }
            state.movies.isEmpty() -> {
                Text(text = "Nenhum filme foi encontrado.")
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = state.movies,
                        key = { it.id }
                    ) { movie ->
                        MovieItem(
                            movie = movie,
                            onClick = { onMovieClick(movie) }
                        )
                    }
                }
            }
        }
    }
}