package com.example.bookshelf.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.model.BookInfo
import com.example.bookshelf.model.ImageLink


@Composable
fun HomeScreen(
    uiState: UiState,
    modifier: Modifier=Modifier,
    contentPadding: PaddingValues= PaddingValues(0.dp),
) {
    when(uiState){
        is UiState.Loading-> LoadingScreen(modifier = Modifier.fillMaxSize())
        is UiState.Error-> ErrorScreen(modifier = Modifier.fillMaxSize())
        is UiState.Success-> GridScreen(
            uiState.bookThumbnail,
            contentPadding = contentPadding,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(
        "Loading..."
    )
}


@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text("Error!")
}


@Composable
fun GridScreen(
    books: List<ImageLink>,
    modifier: Modifier=Modifier,
    contentPadding: PaddingValues= PaddingValues(0.dp)
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(70.dp),
        modifier=modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ) {
        items(
            items=books, key={book->book.httpsLink}
        ){
            book->
            BookCard(
                book = book,
                modifier=modifier.padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(0.5f)
            )
        }
    }
}

@Composable
fun BookCard(
    book: ImageLink, modifier: Modifier=Modifier
){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.httpsLink)
                .crossfade(true)
                .build(),
            contentDescription = "Nothing",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth()
        )
    }
}