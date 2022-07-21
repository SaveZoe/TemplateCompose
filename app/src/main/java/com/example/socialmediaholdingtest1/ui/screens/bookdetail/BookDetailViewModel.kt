package com.example.socialmediaholdingtest1.ui.screens.bookdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaholdingtest1.data.network.NetworkRequestIml
import com.example.socialmediaholdingtest1.data.network.model.SimilarItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(private val networkRequestIml: NetworkRequestIml) :
    ViewModel() {
    private val _carousel: MutableStateFlow<List<SimilarItem>?> = MutableStateFlow(null)
    val carousel: StateFlow<List<SimilarItem>?> = _carousel

    init {
        viewModelScope.launch {
            networkRequestIml.getSimilar().let {
                if (it.isSuccessful) {
                    _carousel.emit(it.body())
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}