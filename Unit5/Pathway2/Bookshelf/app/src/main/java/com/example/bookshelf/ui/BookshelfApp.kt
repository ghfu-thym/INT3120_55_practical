package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.screen.BookshelfViewModel
import com.example.bookshelf.ui.screen.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(){
Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Bookshelf",
                    style = MaterialTheme.typography.bodyLarge
                )
            },

        )
    }
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        val bookshelfViewModel: BookshelfViewModel= viewModel(factory = BookshelfViewModel.Factory)
        HomeScreen(
            uiState = bookshelfViewModel.uiState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = it
        )
    }
}
}

