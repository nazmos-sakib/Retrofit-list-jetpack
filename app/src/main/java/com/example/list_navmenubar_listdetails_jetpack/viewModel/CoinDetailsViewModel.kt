package com.example.list_navmenubar_listdetails_jetpack.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.CoinDetailDto
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.CoinDto
import com.example.list_navmenubar_listdetails_jetpack.model.interfaces.APIService
import kotlinx.coroutines.launch

class CoinDetailsViewModel(private val coinId: String) : ViewModel() {

    var _coinDetails = mutableStateOf(CoinDetailDto(
        description = "",
        developmentStatus= "",
        firstDataAt = "",
        hardwareWallet = true,
        hashAlgorithm = "",
        id = "",
        isActive = false,
        isNew = true,
        tags = emptyList(),
        team = emptyList(),
        lastDataAt = null,
        links = null,
        linksExtended = null,
        message = "",
        name = "",
        openSource = false,
        orgStructure = "",
        proofType = "",
        rank = 0,
        startedAt = "",
        symbol= "",
        type = null,
        whitepaper = null
    ))
        private set



    private val _coinDetailsList = mutableStateListOf<CoinDetailDto>()
    val coinDetails: List<CoinDetailDto>
        get() = _coinDetailsList

    var errorMessage: String by mutableStateOf("")
    fun getCoinDetails() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _coinDetailsList.clear()
                _coinDetailsList.add(apiService.getCoinDetails(coinId))
                //_coinDetails = apiService.getCoinDetails(coinId)
                //nor.ba = apiService.getCoinDetails(coinId).toString()

                Log.d("TAG----->", "getCoinDetails: size "+_coinDetailsList.size)
                Log.d("TAG----->", "getCoinDetails: size "+_coinDetailsList[0].toString())
                errorMessage = _coinDetailsList[0].toString()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}