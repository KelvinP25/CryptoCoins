package com.example.cryptocoins.ui.theme.Coin

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cryptocoins.R
import com.example.cryptocoins.data.remoto.dto.Coin

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CoinScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Crypto Coins",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onPrimary
                    )

                },
                actions = {
                    IconButton(onClick = { navHostController.navigate("RegistroCS") }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar",
                            tint = MaterialTheme.colors.onPrimary

                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.onSecondary,
            )
        },
    ) {
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
}

@Composable
fun CoinItem(
    coin: Coin,
    onClick: (Coin) -> Unit
) {

    val formato = DecimalFormat("#,###.############")
    Card(
        modifier = Modifier
            .clickable { onClick(coin) }
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = coin.imageUrl.toString(),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = coin.descripcion.toString(),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "$ " + formato.format(coin.valor),
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}
