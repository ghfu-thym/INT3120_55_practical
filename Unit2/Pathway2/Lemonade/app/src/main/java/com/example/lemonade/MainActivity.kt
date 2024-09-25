package com.example.lemonade

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeTime by remember { mutableStateOf(2) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(currentStep){
            1->{
                LemonTextAndImage(
                    textId = R.string.tap_tree,
                    drawableId = R.drawable.lemon_tree,
                    descriptionId = R.string.lemon_tree,
                    onImageClick = {
                        currentStep = 2
                        squeezeTime = (2..4).random()
                    }
                )
            }
            2 ->{
                LemonTextAndImage(
                    textId = R.string.keep_tap,
                    drawableId = R.drawable.lemon_squeeze,
                    descriptionId = R.string.lemon,
                    onImageClick = {
                        squeezeTime--
                        if(squeezeTime==0){
                            currentStep=3
                        }
                    }
                )
            }
            3->{
                LemonTextAndImage(
                    textId = R.string.drink,
                    drawableId = R.drawable.lemon_drink,
                    descriptionId = R.string.glass_lemon,
                    onImageClick = {
                        currentStep = 4
                    }
                )
            }
            4->{
                LemonTextAndImage(
                    textId = R.string.again,
                    drawableId = R.drawable.lemon_restart,
                    descriptionId = R.string.empty_glass,
                    onImageClick = {
                        currentStep = 1
                    }
                )
            }
        }
    }
}
@Composable
fun LemonTextAndImage(
    textId:Int,
    drawableId:Int,
    descriptionId: Int,
    onImageClick: ()->Unit,
    modifier: Modifier=Modifier

){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Yellow)
            ) {
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(7f)
                    .fillMaxSize()
            ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableId),
                    contentDescription = stringResource(descriptionId),
                    modifier= Modifier
                        .width(160.dp)
                        .height(160.dp)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(textId),
                fontSize = 18.sp
            )
            }

        }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}