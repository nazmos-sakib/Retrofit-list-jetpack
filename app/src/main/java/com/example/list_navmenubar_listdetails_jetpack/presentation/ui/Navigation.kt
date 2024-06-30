package com.example.list_navmenubar_listdetails_jetpack.presentation.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.list_navmenubar_listdetails_jetpack.Data.notificationList
import com.example.list_navmenubar_listdetails_jetpack.Data.settingList
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.DetailsViewScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.HomeScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.NotificationScreen
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens.SettingsScreen
import com.example.list_navmenubar_listdetails_jetpack.viewModel.CoinDetailsViewModel
import com.example.list_navmenubar_listdetails_jetpack.viewModel.CoinListViewModel
import javax.inject.Inject


@Composable
fun Navigation(navController: NavHostController){

    val vmList = CoinListViewModel()
    val vmDetails = CoinDetailsViewModel()
    //val vmDetails = NewCoinDetailsViewModel()
    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeScreen(
                vm=vmList,
                onItemClick = {
                    navController.navigate("details/$it")
                }
            )
        }
        composable("notification") { NotificationScreen(notificationList= notificationList(), onItemClick = {
            navController.navigate("details/$it")
        }) }
        composable("settings") { SettingsScreen(settings= settingList(), onItemClick = {
            navController.navigate("details/$it")
        }) }

        //--- details route ---
        composable(
            route="details/{item}",
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ){ param->
            Log.d("->>navigation->>", "Navigation: "+param.arguments?.getString("item"))
            param.arguments?.getString("item")?.let {
                DetailsViewScreen(vm=vmDetails,it)
            }
        }//details route end
    }
}
