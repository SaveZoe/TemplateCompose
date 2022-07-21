package com.example.socialmediaholdingtest1.data.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSellerItem(
    val id: Int,
    val title: String,
    val author: String,
    val price: Double,
    val image: String,
    val rate: Rate
) : Parcelable

@Parcelize
data class Rate(
    val score: Double,
    val amount: Int
) : Parcelable