package com.example.list_navmenubar_listdetails_jetpack.Data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.BottomNavBarItemModel
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.ListItemModel
import com.example.list_navmenubar_listdetails_jetpack.R

@Composable
fun  bottomNavMenuItem(): List<BottomNavBarItemModel> = listOf(
    BottomNavBarItemModel(
        title="Home",
        route = "home",
        iconId = ImageVector.vectorResource(id = R.drawable.ic_home)
    ),
    BottomNavBarItemModel(
        title="Notifications",
        route = "notification",
        iconId = ImageVector.vectorResource(id = R.drawable.baseline_notifications_none_24),
        badgeCount = 5
    ),BottomNavBarItemModel(
        title="Setting",
        route = "settings",
        iconId = ImageVector.vectorResource(id = R.drawable.baseline_settings_24)
    ),
)

fun friendList():List<ListItemModel> = listOf(
    ListItemModel("Friend 1"),
    ListItemModel("Friend 2"),
    ListItemModel("Friend 3"),
    ListItemModel("Friend 4"),
    ListItemModel("Friend 5"),
    ListItemModel("Friend 6"),
    ListItemModel("Friend 7"),
    ListItemModel("Friend 8"),
    ListItemModel("Friend 9"),
    ListItemModel("Friend 10"),
)

fun notificationList():List<ListItemModel> = listOf(
    ListItemModel("Notification 1"),
    ListItemModel("Notification 2"),
    ListItemModel("Notification 3"),
    ListItemModel("Notification 4"),
)

fun settingList():List<ListItemModel> = listOf(
    ListItemModel("Profile"),
    ListItemModel("Edit"),
)