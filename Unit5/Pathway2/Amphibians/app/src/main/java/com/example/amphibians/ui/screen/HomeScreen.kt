package com.example.amphibians.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.model.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme


@Composable
fun HomeScreen(
    amphibiansState: AmphibiansState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (amphibiansState) {
        is AmphibiansState.Loading -> LoadingScreen(modifier = modifier.fillMaxWidth())
        is AmphibiansState.Success -> LazyColumScreen(
            amphibians = amphibiansState.amphibians,
            modifier
        )

        is AmphibiansState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Loading, please wait...",
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Something wrong",
        style = MaterialTheme.typography.bodyLarge
    )
}


@Composable
fun AmphibianPhotoCard(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {
            Text(
                text = amphibian.name + " (${amphibian.type})",
                style = MaterialTheme.typography.headlineMedium
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.img_src)
                    .crossfade(true)
                    .build(),
                contentDescription = "Amphibian Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = amphibian.description
            )
        }

    }
}

@Composable
fun LazyColumScreen(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier.padding(4.dp),
        contentPadding = contentPadding
    ) {
        itemsIndexed(amphibians) { index, amphibian ->
            AmphibianPhotoCard(
                amphibian,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }
    }
}

@Preview
@Composable
fun LoadingPreview() {
    AmphibiansTheme {
        LoadingScreen()
    }
}
