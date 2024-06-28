package com.example.list_navmenubar_listdetails_jetpack.model.interfaces

import com.example.list_navmenubar_listdetails_jetpack.Data.Model.Coin
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.CoinDetailDto
import com.example.list_navmenubar_listdetails_jetpack.Data.Model.dto.CoinDto
import com.example.list_navmenubar_listdetails_jetpack.common.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}/")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailDto

    companion object {
        private var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}