package com.example.android.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1.0f, true)
                    .background(Color.Green)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(R.string.t1),
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = stringResource(R.string.t2),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1.0f, true)
                    .background(Color.Yellow)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(R.string.t3),
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.t4), textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
        Row(
            modifier = Modifier.weight(1.0f, true)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1.0f, true)
                    .background(Color.Cyan)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(R.string.t5),
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.t6), textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1.0f, true)
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(R.string.t7),
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.t8), textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}