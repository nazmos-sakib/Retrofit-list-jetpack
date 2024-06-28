package com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.ListItemModel
import com.example.list_navmenubar_listdetails_jetpack.Data.friendList
import com.example.list_navmenubar_listdetails_jetpack.Data.settingList
import com.example.list_navmenubar_listdetails_jetpack.presentation.ui.theme.ListnavmenubarlistdetailsjetpackTheme
import com.example.list_navmenubar_listdetails_jetpack.viewModel.CoinListViewModel


@Composable
fun HomeScreen(
    vm: CoinListViewModel,
    onItemClick:(String)->Unit
){
    LaunchedEffect(Unit, block = {
        vm.getCoinList()
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        //contentAlignment = Alignment.Center
    ){
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp)
        ) {
            itemsIndexed(
                vm.coinList
            ){index, item ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item.id)
                    },
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Text(text = (index+1).toString())
                    Text(
                        text = item.name,

                    )
                    Text(text = if (item.isActive) "Active" else "Inactive")
                }

            }
        }

    }
}

