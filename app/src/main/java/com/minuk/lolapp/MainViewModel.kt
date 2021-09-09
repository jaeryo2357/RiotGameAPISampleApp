package com.minuk.lolapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minuk.lolapp.data.RiotRepository
import com.minuk.lolapp.network.Result
import com.minuk.lolapp.network.model.Champions
import com.minuk.lolapp.ui.champion.ChampionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val riotRepository: RiotRepository,
    private val dispatchers: CoroutineDispatcher
): ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    private val _champions = MutableStateFlow<List<ChampionModel>>(emptyList())
    val champions: StateFlow<List<ChampionModel>> = _champions


    init {
         requestRiotLeaderBoards()
    }

    private fun showProgressBar() {
        _isLoading.value = true
    }

    private fun hideProgressBar() {
        _isLoading.value = false
    }

    fun requestRiotLeaderBoards() = viewModelScope.launch(dispatchers) {
        try {
            showProgressBar()

            when(val response = riotRepository.getChampions()) {
                is Result.Success -> {
                    _champions.value = response.date
                }
                is Result.Error -> {
                    response.message?.let {
                        _errorMessage.value = it
                    }
                }
            }

        } finally {
            hideProgressBar()
        }
    }
}