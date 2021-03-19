package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun LoginScreen(
    goHome: (() -> Unit)?
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_login_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = "Welcome\nback",
                style = typography.h2,
                color = colors.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                value = "",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.MailOutline,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Email address",
                        style = typography.body1,
                        color = colors.onSurface
                    )
                },
                onValueChange = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth(),
                value = "",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Password,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Password",
                        style = typography.body1,
                        color = colors.onSurface
                    )
                },
                onValueChange = { /*TODO*/ }
            )

            Button(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(48.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50)),
                onClick = { goHome?.invoke() }
            ) {
                Text(
                    text = "LOG IN",
                    textAlign = TextAlign.Center,
                    style = typography.button,
                    color = colors.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun DarkViewLoginScreen() {
    MyTheme(darkTheme = true) {
        LoginScreen(null)
    }
}

@Preview
@Composable
fun LightViewLoginScreen() {
    MyTheme(darkTheme = false) {
        LoginScreen(null)
    }
}