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
            ComposeInfoCard(
                title = stringResource(id = R.string.t1),
                desc = stringResource(id = R.string.t2),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1.0f)
            )
            ComposeInfoCard(
                title = stringResource(id = R.string.t3),
                desc = stringResource(id = R.string.t4),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1.0f)
            )
        }
        Row(
            modifier = Modifier.weight(1.0f, true)
        ) {
            ComposeInfoCard(
                title = stringResource(id = R.string.t5),
                desc = stringResource(id = R.string.t6),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1.0f)
            )
            ComposeInfoCard(
                title = stringResource(id = R.string.t7),
                desc = stringResource(id = R.string.t8),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1.0f)
            )
        }
    }
}

@Composable
fun ComposeInfoCard(
    title: String,
    desc: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = desc, textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}