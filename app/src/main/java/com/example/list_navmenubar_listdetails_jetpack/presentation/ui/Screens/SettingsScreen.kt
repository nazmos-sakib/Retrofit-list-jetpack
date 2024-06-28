package com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.ListItemModel
import com.example.list_navmenubar_listdetails_jetpack.Data.settingList
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.theme.ListnavmenubarlistdetailsjetpackTheme

@Composable
fun SettingsScreen(
    settings: List<ListItemModel>,
    onItemClick:(String)->Unit
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LazyColumn {
            itemsIndexed(
                settings
            ){index, item ->
                Text(
                    text = item.itemName,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            onItemClick(item.itemName)
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListnavmenubarlistdetailsjetpackTheme {
        SettingsScreen(settingList(), onItemClick = {})
    }
}