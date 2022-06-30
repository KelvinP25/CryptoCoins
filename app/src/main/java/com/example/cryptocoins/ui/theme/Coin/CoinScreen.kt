package com.example.cryptocoins.ui.theme.Coin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.cryptocoins.data.remoto.dto.Coin

@Composable
fun CoinScreen(
    viewModel: CoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(state.coins) { coin ->
                CoinItem(
                    coin = coin,
                    {}
                )
            }

        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}
@Composable
fun CoinItem(
    coin: Coin,
    onClick: (Coin) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxSize()
        .clickable { onClick(coin) }
        .padding(16.dp)
    ) {
        AsyncImage(
            model = coin.imagenUrl,
            contentDescription = null
        )

        Text(
            text = "",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${coin.valor} (${coin.descricion})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }

}