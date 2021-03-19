package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(
    goLogin: (() -> Unit)?
) {
    Scaffold() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_welcome_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )

            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .clip(RoundedCornerShape(50)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colors.primary,
                            contentColor = colors.onPrimary
                        )
                    ) {
                        Text(text = "GET STARTED")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { goLogin?.invoke() },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .border(1.dp, colors.primary, RoundedCornerShape(50))
                            .clip(RoundedCornerShape(50)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Transparent,
                            contentColor = colors.primary
                        )
                    ) {
                        Text(text = "LOG IN")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DarkView() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(null)
    }
}

@Preview
@Composable
fun LightView() {
    MyTheme(darkTheme = false) {
        WelcomeScreen(null)
    }
}

