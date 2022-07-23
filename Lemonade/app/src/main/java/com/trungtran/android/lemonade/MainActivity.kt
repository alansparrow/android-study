package com.trungtran.android.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trungtran.android.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemondadeApp()
            }
        }
    }
}

@Composable
fun LemondadeApp() {
    CardButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Preview(showBackground = true)
@Composable
fun CardButton(modifier: Modifier = Modifier) {
    var stepIdx by rememberSaveable { mutableStateOf(0) }
    val steps: Array<String> = stringArrayResource(id = R.array.lemonade_steps)
    val stepsDesc: Array<String> = stringArrayResource(id = R.array.lemonade_steps_desc)

    val img = when(stepIdx) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = steps[stepIdx]
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = img), contentDescription = stepsDesc[stepIdx],
        modifier = Modifier.border(2.dp, color = Color(105,205, 216)))
    }
}