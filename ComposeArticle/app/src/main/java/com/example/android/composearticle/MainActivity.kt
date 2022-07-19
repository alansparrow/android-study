package com.example.android.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticle()
                }
            }
        }
    }
}

@Composable
fun ComposeArticle() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column() {
        Image(
            painter = image, contentDescription = null, modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.jp_tutorial_text),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.jp_explanation_text),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.jp_tutorial_detail_text),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ComposeArticle()
    }
}