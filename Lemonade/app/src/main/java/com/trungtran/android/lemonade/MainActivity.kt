package com.trungtran.android.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Preview(showBackground = true)
@Composable
fun LemondadeApp() {
    CardButton(
        stringArrayResource(id = R.array.lemonade_steps),
        stringArrayResource(id = R.array.lemonade_steps_desc),
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun CardButton(steps: Array<String>, stepsDesc: Array<String>, modifier: Modifier = Modifier) {
    var squeezeCount by rememberSaveable { mutableStateOf((1..10).random()) }
    var stepIdx by rememberSaveable { mutableStateOf(0) }


    val img = when (stepIdx) {
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
            text = steps[stepIdx],
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = img), contentDescription = stepsDesc[stepIdx],
            modifier = Modifier
                .border(
                    2.dp, color = Color(
                        getRandomColorLevel(), getRandomColorLevel(), getRandomColorLevel()
                    ),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable {
                    if (stepIdx == 1) {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            squeezeCount = (1..10).random()
                            stepIdx = 2;
                        }
                    } else {
                        stepIdx = (stepIdx + 1) % 4
                    }
                })
        if (stepIdx == 1) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Squeeze: $squeezeCount"
            )
        }
    }
}

fun getRandomColorLevel(): Int {
    return (0..255).random()
}