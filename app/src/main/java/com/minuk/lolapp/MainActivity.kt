package com.minuk.lolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    val championsState = viewModel.champions.collectAsState()
    val loadingState = viewModel.isLoading.collectAsState()
    val errorMessage = viewModel.errorMessage.collectAsState()

    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            ChampionList(
                modifier = Modifier.fillMaxSize(),
                champions = championsState.value
            )

            if (loadingState.value) {
                CircularProgressIndicator(progress = 0.5f)
            }

            if (errorMessage.value.isNotEmpty()) {
                Snackbar{
                    Text(text = errorMessage.value)
                }
            }
        }
    }
}