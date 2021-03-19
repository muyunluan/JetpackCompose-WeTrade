package com.example.androiddevchallenge

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    BottomSheet()
}

@Composable
fun MainContent() {
    Scaffold() {
        Column(
            modifier = Modifier
                .background(color = colors.background)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(64.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "ACCOUNT",
                    modifier = Modifier
                        .weight(1f),
                    style = typography.button,
                    color = colors.onBackground,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "WATCHLIST",
                    modifier = Modifier
                        .weight(1f),
                    style = typography.button,
                    color = colors.onBackground.copy(0.5f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "PROFILE",
                    modifier = Modifier
                        .weight(1f),
                    style = typography.button,
                    color = colors.onBackground.copy(0.5f),
                    textAlign = TextAlign.Center
                )
            }

            Text(
                text = "Balance",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(32.dp)
                    .fillMaxWidth(),
                style = typography.subtitle1,
                color = colors.onBackground,
                textAlign = TextAlign.Center
            )

            Text(
                text = "$73,589.01",
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(48.dp)
                    .fillMaxWidth(),
                style = typography.h1,
                color = colors.onBackground,
                textAlign = TextAlign.Center
            )

            Text(
                text = "+412.35 today",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .height(16.dp)
                    .fillMaxWidth(),
                style = typography.subtitle1,
                color = colors.secondary,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                    .height(48.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(50))
            ) {
                Text(
                    text = "TRANSACT",
                    style = typography.button,
                    color = colors.onPrimary,
                    textAlign = TextAlign.Center
                )
            }

            val items = remember { DataProvider.scrollItems }
            val selectedIndex = remember { mutableStateOf(0) }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                ScrollableTabRow(
                    selectedTabIndex = selectedIndex.value,
                    edgePadding = 16.dp,
                    backgroundColor = Color.Transparent,
                    divider = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                ) {
                    items.forEachIndexed{index, item ->
                        Tab(
                            selected = index == selectedIndex.value,
                            onClick = { /*TODO*/ }
                        ) {
                            ScrollItem(item = item)
                        }
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_home_illos),
                contentDescription = null,
                modifier = Modifier.padding(top = 16.dp)
            )

            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp)
            ) {
                Text(
                    text = "Positions",
                    style = typography.subtitle1,
                    color = colors.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                        .background(color = colors.surface)
                )
            }

        }
    }
}

@Composable
fun ScrollItem(item: Pair<String, Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .border(
                BorderStroke(1.dp, colors.onBackground),
                RoundedCornerShape(50)
            )
            .defaultMinSize(72.dp)
            .height(40.dp)
    ) {
        Text(
            text = item.first,
            style = typography.body1,
            color = colors.onBackground,
            textAlign = TextAlign.Center
        )
        if (item.second) {
            Icon(
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(16.dp)
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun PositionBottomSheet(list: @Composable () -> Unit) {
    val bottomSheetState =
        rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed,
            confirmStateChange = {
                true
            }
        )
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val bottomSheetScaffoldState = BottomSheetScaffoldState(
        drawerState = drawerState,
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed),
        snackbarHostState = snackbarHostState
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {list},
        modifier = Modifier.fillMaxSize(),
        sheetShape = RectangleShape,
        sheetPeekHeight = 64.dp,
        sheetElevation = 0.dp,
        content = {
            MainContent()
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun BottomSheet() {
    val drawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
    BottomDrawer(
        drawerState = drawerState,
        drawerShape = RectangleShape,
        drawerContent = {
            Text(
                text = "Positions",
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 24.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.subtitle1
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colors.surface)
            ) {
                DataProvider.fakeTrades.forEach {
                    item {
                        PositionItem(item = it)
                    }
                }
            }
        }
    ) {
        MainContent()
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun DarkViewHomeScreen() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun LightViewHomeScreen() {
    MyTheme(darkTheme = false) {
        HomeScreen()
    }
}