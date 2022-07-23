package com.trungtran.android.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.trungtran.android.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollApp()
            }
        }
    }
}


@Composable
fun DiceRollApp() {
    DiceWithButtonImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Preview(showBackground = true)
@Composable
fun DiceWithButtonImage(modifier: Modifier = Modifier) {

}
