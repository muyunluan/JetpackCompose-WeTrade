package com.example.androiddevchallenge

import android.provider.ContactsContract
import android.provider.ContactsContract.Profile
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavHost() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen {
                navHostController.navigate("login")
            }
        }

        composable("login") {
            LoginScreen{
                navHostController.navigate("home")
            }
        }

        composable("home") {
            HomeScreen()
        }
    }
}