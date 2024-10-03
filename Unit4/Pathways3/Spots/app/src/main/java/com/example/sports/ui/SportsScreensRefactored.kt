
/*
 * Copyright (c) 2023 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      https://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sports.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sports.R
import com.example.sports.data.LocalSportsDataProvider
import com.example.sports.model.Sport
import com.example.sports.ui.theme.SportsTheme

// Extracting common padding values for reuse
val commonPadding = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))

// Sports List Screen Composable
@Composable
fun SportsListScreen(
    sports: List<Sport>,
    onClick: (Sport) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(top = dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(sports) { sport ->
            SportsListItem(sport = sport, onItemClick = onClick)
        }
    }
}

// Sports Detail Screen Composable
@Composable
fun SportsDetailScreen(
    selectedSport: Sport,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = selectedSport.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(dimensionResource(R.dimen.padding_small))
            )
        }
        Image(
            painter = painterResource(selectedSport.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = selectedSport.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
    }
}

// Composable displaying both Sports List and Detail
@Composable
fun SportsListAndDetail(
    sports: List<Sport>,
    selectedSport: Sport,
    onClick: (Sport) -> Unit,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Row(modifier = modifier) {
        SportsListScreen(
            sports = sports,
            onClick = onClick,
            modifier = commonPadding.weight(2f)
        )
        SportsDetailScreen(
            selectedSport = selectedSport,
            onBackPressed = onBackPressed,
            modifier = Modifier.weight(3f).padding(contentPadding)
        )
    }
}

// Preview functions for testing UI components
@Preview
@Composable
fun SportsListItemPreview() {
    SportsTheme {
        SportsListItem(sport = LocalSportsDataProvider.defaultSport, onItemClick = {})
    }
}

@Preview
@Composable
fun SportsListPreview() {
    SportsTheme {
        Surface {
            SportsListScreen(
                sports = LocalSportsDataProvider.getSportsData(),
                onClick = {}
            )
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
fun SportsListAndDetailPreview() {
    SportsTheme {
        Surface {
            SportsListAndDetail(
                sports = LocalSportsDataProvider.getSportsData(),
                selectedSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                    LocalSportsDataProvider.defaultSport
                },
                onClick = {},
                onBackPressed = {}
            )
        }
    }
}
