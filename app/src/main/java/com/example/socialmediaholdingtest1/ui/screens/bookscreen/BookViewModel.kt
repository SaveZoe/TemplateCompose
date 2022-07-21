package com.example.socialmediaholdingtest1.ui.screens.bookscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaholdingtest1.data.network.NetworkRequestIml
import com.example.socialmediaholdingtest1.data.network.model.BestSellerItem
import com.example.socialmediaholdingtest1.data.network.model.CarouselItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val networkData: NetworkRequestIml) : ViewModel() {
    private val _carousel = MutableStateFlow<List<CarouselItem>?>(null)
    val carousel: StateFlow<List<CarouselItem>?> = _carousel

    private val _bestSeller = MutableStateFlow<List<BestSellerItem>?>(null)
    val bestSeller: StateFlow<List<BestSellerItem>?> = _bestSeller

    init {
        viewModelScope.launch {
            networkData.getCarousel().let {
                if (it.isSuccessful) {
                    _carousel.emit(it.body())
                }
            }
            networkData.getBestSeller().let {
                if (it.isSuccessful) {
                    _bestSeller.emit(it.body())
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}