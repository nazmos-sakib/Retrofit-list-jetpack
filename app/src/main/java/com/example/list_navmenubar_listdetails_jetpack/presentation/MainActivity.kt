package com.example.list_navmenubar_listdetails_jetpack.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.list_navmenubar_listdetails_jetpack.Data.bottomNavMenuItem
import com.example.list_navmenubar_listdetails_jetpack.Data.friendList
import com.example.list_navmenubar_listdetails_jetpack.Data.notificationList
import com.example.list_navmenubar_listdetails_jetpack.Data.settingList
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Navigation
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.DetailsViewScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.HomeScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.NotificationScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.SettingsScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.theme.ListnavmenubarlistdetailsjetpackTheme
import com.example.list_navmenubar_listdetails_jetpack.viewModel.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListnavmenubarlistdetailsjetpackTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavMenu(
                            items = bottomNavMenuItem(),
                            navController = navController,
                            modifier = Modifier,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListnavmenubarlistdetailsjetpackTheme {

    }
}