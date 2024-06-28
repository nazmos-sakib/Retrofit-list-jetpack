package com.example.list_navmenubar_listdetails_jetpack.presentation.ui.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.list_navmenubar_listdetails_jetpack.viewModel.CoinDetailsViewModel

@Composable
fun DetailsViewScreen(
    vm: CoinDetailsViewModel
) {
    LaunchedEffect(Unit, block = {
        vm.getCoinDetails()
    })



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        
        Text(text = "details")
        Spacer(modifier = Modifier.height(30.dp))
        
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(10.dp)
        ) {
            itemsIndexed(
                vm.coinDetails
            ) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        },
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    Text(text = (index + 1).toString())
                    Text(
                        color = Color.White,
                        text = item.description,
                        )
                    Text(text = if (item.isActive) "Active" else "Inactive")
                }

            }
        }
        Text(text = vm.errorMessage)
    }
}