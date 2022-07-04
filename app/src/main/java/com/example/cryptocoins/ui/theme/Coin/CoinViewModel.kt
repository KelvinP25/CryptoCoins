package com.example.cryptocoins.ui.theme.Coin

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocoins.data.remoto.dto.Coin
import com.example.cryptocoins.data.remoto.dto.CoinListState
import com.example.cryptocoins.data.repository.CoinRepository
import com.example.cryptocoins.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val coinRepository: CoinRepository
): ViewModel(){
    var _description by mutableStateOf("")
    var _valor by mutableStateOf("")
    var _image by mutableStateOf("")

    private var _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        coinRepository.getCoins().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)
    }


    fun Post(){
        viewModelScope.launch {
            coinRepository.postCoin(
                Coin(
                    descripcion = _description,
                    valor = _valor.toDouble(),
                    imageUrl = _image
                )
            )
        }
    }
}