package com.minuk.lolapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minuk.lolapp.data.RiotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val riotRepository: RiotRepository,
    private val dispatchers: CoroutineDispatcher
): ViewModel() {

    init {
         requestRiotLeaderBoards()
    }

    fun requestRiotLeaderBoards() = viewModelScope.launch(dispatchers) {
        val response = riotRepository.getLeaderboards()
        Log.d("response", response.toString())
    }
}