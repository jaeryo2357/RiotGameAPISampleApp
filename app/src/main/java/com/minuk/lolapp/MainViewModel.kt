package com.minuk.lolapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minuk.lolapp.data.RiotRepository
import com.minuk.lolapp.network.Result
import com.minuk.lolapp.network.model.Champion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val riotRepository: RiotRepository,
    private val dispatchers: CoroutineDispatcher
): ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _errorMessage = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    private val _champions = MutableLiveData<List<Champion>>(emptyList())
    val champions: LiveData<List<Champion>> = _champions


    init {
         requestRiotLeaderBoards()
    }

    private fun showProgressBar() {
        _isLoading.postValue(true)
    }

    private fun hideProgressBar() {
        _isLoading.postValue(false)
    }

    fun requestRiotLeaderBoards() = viewModelScope.launch(dispatchers) {
        try {
            showProgressBar()
            when(val response = riotRepository.getChampions()) {
                is Result.Success -> {
                    _champions.postValue(response.date)
                }
                is Result.Error -> {
                    response.message?.let {
                        _errorMessage.postValue(it)
                    }
                }
            }

        } finally {
            hideProgressBar()
        }
    }
}