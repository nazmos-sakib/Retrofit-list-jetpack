package com.example.list_navmenubar_listdetails_jetpack.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.CoinDetailsMutableState
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.CoinDetailDto
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.toCoinDetail
import com.example.list_navmenubar_listdetails_jetpack.model.interfaces.APIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinDetailsViewModel @Inject constructor( ) : ViewModel() {

    //state solution ------
    private val _state = mutableStateOf(CoinDetailsMutableState(coinDetails=null))
    val state: State<CoinDetailsMutableState>
        get()  = _state
    //state end

    //another solution
    private val _coinDetailsList = mutableStateListOf<CoinDetailDto>()
    val coinDetails: List<CoinDetailDto>
        get() = _coinDetailsList
    //another solution end

    //another solution 2
    var res = mutableStateOf("")
    //2 end

    var errorMessage: String by mutableStateOf("")
    fun getCoinDetails(coinId: String) {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                 val temp = apiService.getCoinDetails(coinId)
                res.value = temp.toCoinDetail().toString()

                Log.d("<<TAG>>", "getCoinDetails: $temp")

                _state.value = CoinDetailsMutableState(
                    isLoading = false,
                    coinDetails = temp.toCoinDetail(),
                    error = ""
                )
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}