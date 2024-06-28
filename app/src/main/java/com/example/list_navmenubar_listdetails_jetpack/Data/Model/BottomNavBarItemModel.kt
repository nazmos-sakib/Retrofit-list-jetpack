package com.example.list_navmenubar_listdetails_jetpack.Data.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItemModel(
    val title: String,
    val route: String,
    val iconId: ImageVector,
    val badgeCount: Int = 0
)
