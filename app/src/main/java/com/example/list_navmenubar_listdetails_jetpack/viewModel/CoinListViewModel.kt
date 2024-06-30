package com.example.list_navmenubar_listdetails_jetpack.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.CoinDto
import com.example.list_navmenubar_listdetails_jetpack.model.interfaces.APIService
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinListViewModel @Inject constructor( ) : ViewModel() {

    // remember is a part of @Composable
    private val _coinList = mutableStateListOf<CoinDto>()
    var errorMessage: String by mutableStateOf("")

    val coinList: List<CoinDto>
        get() = _coinList

    fun getCoinList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _coinList.clear()
                _coinList.addAll(apiService.getCoins())

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}

