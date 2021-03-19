package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PositionItem(item: Trade) {
    Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
    )

    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(
                text = item.price,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 0.dp),
                style = typography.body1
            )
            if (item.change >= 0f) {
                Text(
                    text = "+" + item.change + "%",
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                    style = typography.body1
                )
            } else {
                Text(
                    text = "" + item.change + "%",
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp),
                    style = typography.body1
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 24.dp)
        ) {
            Text(
                text = item.code,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 0.dp),
                style = typography.h3
            )
            Text(
                text = item.company,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 0.dp),
                style = typography.h3
            )
        }

        Image(
            painter = painterResource(id = item.pic),
            contentDescription = null,
            modifier = Modifier.height(24.dp)
        )
    }
}

@Preview
@Composable
fun DarkViewPositionItem() {
    MyTheme(darkTheme = true) {
        Column() {
            PositionItem(item = DataProvider.fakeTrades[0])

            PositionItem(item = DataProvider.fakeTrades[1])
        }
    }
}

@Preview
@Composable
fun LightViewPositionItem() {
    MyTheme(darkTheme = false) {
        Column() {
            PositionItem(item = DataProvider.fakeTrades[0])

            PositionItem(item = DataProvider.fakeTrades[1])
        }
    }
}