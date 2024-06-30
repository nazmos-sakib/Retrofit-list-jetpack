package com.example.list_navmenubar_listdetails_jetpack.Data.Model

data class CoinDetailsMutableState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetail?,
    val error: String = ""
)
