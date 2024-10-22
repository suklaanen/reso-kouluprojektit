package com.example.groupfour.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.groupfour.ui.screens.bottom.CustomBottomAppBar
import com.example.groupfour.ui.theme.FirstTheme
import com.example.groupfour.ui.screens.home.Home
import com.example.groupfour.ui.screens.navi.Navi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groupfour.ui.screens.uiAccountStuff.AccountStuff
import com.example.groupfour.ui.screens.uiMeetingStuff.MeetingStuff
import com.example.groupfour.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FirstTheme {
                val mainViewModel: MainViewModel = viewModel()

                mainViewModel.simulateLoading()
                MainScreen(mainViewModel)
            }
        }
    }

    @Composable
    fun MainScreen(mainViewModel: MainViewModel) {
        val navController = rememberNavController()
        val isLoading by mainViewModel.isLoading.collectAsState()
        val isUserLoggedIn by mainViewModel.isUserLoggedIn.collectAsState()

        Scaffold(
            topBar = { Navi(navController) },
            bottomBar = { CustomBottomAppBar(navController) }
        ) { innerPadding ->
            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    Modifier
                        .padding(innerPadding)
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    composable("home") { Home(navController) }
                    composable("navigateAccount") { AccountStuff(navController, isUserLoggedIn) }
                    composable("navigateMeetings") { MeetingStuff(navController, isUserLoggedIn) }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        FirstTheme {
            val mainViewModel: MainViewModel = MainViewModel()
            MainScreen(mainViewModel)
        }
    }
}