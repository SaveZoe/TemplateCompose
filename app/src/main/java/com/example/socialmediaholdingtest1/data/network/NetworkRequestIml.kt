package com.example.socialmediaholdingtest1.data.network

import javax.inject.Inject

class NetworkRequestIml @Inject constructor(private val network: NetworkRequest) {
    suspend fun getCarousel() = network.getCarousel()
    suspend fun getSimilar() = network.getSimilar()
    suspend fun getBestSeller() = network.getBestSeller()
}