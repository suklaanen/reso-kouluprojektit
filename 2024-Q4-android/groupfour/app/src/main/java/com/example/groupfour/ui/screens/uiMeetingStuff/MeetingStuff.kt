package com.example.groupfour.ui.screens.uiMeetingStuff

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.groupfour.ui.components.DogBackgrounds

@Composable
fun MeetingStuff(navController: NavController, isUserLoggedIn: Boolean) {

    DogBackgrounds()
    rememberScrollState()

    if (isUserLoggedIn) {
        LoggedInView(navController)
    } else {
        LoggedOutView(navController)
    }
}