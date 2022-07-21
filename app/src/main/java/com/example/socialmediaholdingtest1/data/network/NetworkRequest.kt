package com.example.socialmediaholdingtest1.data.network

import com.example.socialmediaholdingtest1.data.network.model.*
import retrofit2.Response
import retrofit2.http.GET

interface NetworkRequest {
    @GET("carousel")
    suspend fun getCarousel(): Response<List<CarouselItem>>

    @GET("best")
    suspend fun getBestSeller(): Response<List<BestSellerItem>>

    @GET("similar")
    suspend fun getSimilar(): Response<List<SimilarItem>>
}