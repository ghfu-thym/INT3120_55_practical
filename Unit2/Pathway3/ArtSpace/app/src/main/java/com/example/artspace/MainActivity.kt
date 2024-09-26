package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentPage by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color =MaterialTheme.colorScheme.background
    ) {
        when(currentPage){
            1->{
                ArtSpaceShow(
                    imageID = R.drawable.screenshot_2024_09_26_131152,
                    imageNameId = R.string.pink_space,
                    artisId = R.string.artis_name,
                    onNext = {
                        currentPage=2
                    },
                    onPrevious = {
                        currentPage=3
                    }

                )
            }
            2 ->{
                ArtSpaceShow(
                    imageID = R.drawable.screenshot_2024_09_26_131214,
                    imageNameId = R.string.blue_space,
                    artisId = R.string.artis_name,
                    onNext = {
                        currentPage =3
                    },
                    onPrevious = {
                        currentPage =1
                    }
                )
            }
            3 ->{
                ArtSpaceShow(
                    imageID = R.drawable.screenshot_2024_09_26_131232,
                    imageNameId = R.string.beach,
                    artisId = R.string.artis_name,
                    onNext = {
                        currentPage=1
                    },
                    onPrevious = {
                        currentPage =2
                    }
                )
            }
        }
    }
}
@Composable
fun ArtSpaceShow(
    imageID: Int,
    imageNameId:Int,
    artisId: Int,
    onNext: ()->Unit,
    onPrevious: ()->Unit,
    modifier: Modifier=Modifier

){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(10.dp)
    ){
        Image(
            painter = painterResource(imageID),
            contentDescription = stringResource(imageNameId),
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(top = 50.dp)
                .border(width = 20.dp, color = Color.LightGray,)
                .shadow(5.dp)

        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .weight(0.7f)
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(imageNameId),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(artisId),
                fontSize = 14.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .weight(0.5f)
                .fillMaxWidth()

        ) {
            Button(
                onClick = onPrevious,
                shape = RoundedCornerShape(20.dp) ,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Previous",
                    color = Color.White
                )
            }
            Button(
                onClick = onNext,
                shape = RoundedCornerShape(20.dp) ,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.width(100.dp)
            ) {
                Text(
                    text = "Next",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}