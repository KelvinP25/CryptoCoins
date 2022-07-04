package com.example.cryptocoins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocoins.ui.theme.Coin.CoinScreen
import com.example.cryptocoins.ui.theme.Coin.RegistroCoinScreen
import com.example.cryptocoins.ui.theme.CryptoCoinsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCoinsTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val navHostController = rememberNavController()

        NavHost(navController = navHostController, startDestination = "SplashScreen") {
            composable(route = "CoinScreen") {
                CoinScreen(navHostController)
            }
            composable(route = "RegistroCS") {
                RegistroCoinScreen(navHostController)
            }
            composable(route = "SplashScreen") {
                SplashScreen(navHostController)
            }
        }
    }
}

@Composable
fun SplashScreen( navHostController: NavHostController) {
    LaunchedEffect(key1 = true){
        delay(5000)
        navHostController.popBackStack()
        navHostController.navigate("CoinScreen")
    }

    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.btc_crypto_cryptocurrency_cryptocurrencies_cash_money_bank_payment_95084),
            contentDescription = "Crypto",
            Modifier.size(150.0.dp, 150.0.dp)
        )
        Text(
            text = "Crypto Coins",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
