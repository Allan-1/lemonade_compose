package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
              LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp(){
    var currentStep by remember { mutableStateOf(1) }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background){
        when(currentStep){
            1 -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.tap_lemon))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_tree), contentDescription = currentStep.toString(),
                    Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 2 })
            }
            2 -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.keep_tapping))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_squeeze), contentDescription = currentStep.toString(),
                    Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 3 })
            }
            3 -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.drink_it))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_drink), contentDescription = currentStep.toString(),
                    Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 4 })
            }
            4 -> Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.empty_glass))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_restart), contentDescription = currentStep.toString(),
                    Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 1 })
            }
            else -> {
                Text(text = "No Lemon")
            }
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