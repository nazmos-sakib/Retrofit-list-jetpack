package com.example.list_navmenubar_listdetails_jetpack.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.BottomNavBarItemModel


@Composable
fun BottomNavMenu(
    items:List<BottomNavBarItemModel>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavBarItemModel) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = Color.LightGray,
        contentColor = Color.Black
    ){
        items.forEach {item->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Green,
                    selectedTextColor = Color.White,
                    selectedIndicatorColor = Color.Gray,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Black,
                    disabledIconColor = Color.Black,
                    disabledTextColor = Color.Black,
                ),
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(top = 15.dp),
                    ) {
                        if(item.badgeCount > 0){
                            BadgedBox(
                                badge = {
                                    Badge(
                                        modifier = Modifier,
                                        containerColor  = BadgeDefaults.containerColor,
                                        contentColor = contentColorFor(containerColor),
                                        content = {
                                            Text(text = item.badgeCount.toString())
                                        })
                                }
                            ) {
                                Icon(
                                    imageVector = item.iconId,
                                    contentDescription = item.title,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.iconId,
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                        if(selected){
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }

                    }
                }
            )
        }

    }
}



