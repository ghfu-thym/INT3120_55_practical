package com.example.a30days

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30days.model.Tip
import com.example.a30days.model.TipsData
import com.example.compose._30DaysTheme

@Composable
fun ListTips(
    tips: List<Tip>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding
    ) {
        itemsIndexed(tips) { index, tip ->
            SingleTip(tip, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }
    }
}

@Composable
fun SingleTip(
    tip: Tip,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Day ${tip.day}",
                style = MaterialTheme.typography.displaySmall,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraLight
            )
            Text(
                text = stringResource(tip.nameRes),
                style = MaterialTheme.typography.displaySmall,
                fontSize = 24.sp
            )

            Image(
                painter = painterResource(tip.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(width = 400.dp, height = 260.dp)
            )
            Text(
                text = stringResource(tip.descriptionRes),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp
            )
        }
    }
}


@Preview(name = "Single tip")
@Composable
fun tipPreview() {
    _30DaysTheme {
        val tip = Tip(
            day = 0,
            nameRes = R.string.day1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.images
        )
        SingleTip(tip = tip)
    }
}

@Preview(name = "list")
@Composable
fun listPreview() {
    _30DaysTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ListTips(tips = TipsData.tips)
        }
    }
}