package com.minuk.lolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minuk.lolapp.ui.champion.ChampionList
import com.minuk.lolapp.ui.theme.LoLAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoLAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val championsState = viewModel.champions.observeAsState(emptyList())
    val loadingState = viewModel.isLoading.observeAsState()
    val errorMessage = viewModel.errorMessage.observeAsState()

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            ChampionList(
                modifier = Modifier.fillMaxSize(),
                champions = championsState.value
            )

            if (loadingState.value == true) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    progress = 0.5f
                )
            }

            if (!errorMessage.value.isNullOrEmpty()) {
                Snackbar{
                    Text(text = errorMessage.value!!)
                }
            }
        }
    }
}