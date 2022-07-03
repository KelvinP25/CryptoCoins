package com.example.cryptocoins.ui.theme.Coin

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cryptocoins.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegistroCoinScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(horizontal = 18.dp),
                        text = "Registro Grypto Coin",
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Consulta de Coin",
                            tint = MaterialTheme.colors.onPrimary

                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.onSecondary,
            )
        },


        ) {

        Column(Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Moneda") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyBitcoin,
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Precio") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(28.dp))
            Button(onClick = {},

                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onSecondary,
                    contentColor = MaterialTheme.colors.onPrimary,
                ),
                shape = CutCornerShape(6.dp),

            ){
                Text(
                    text = "Guardar",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 18.sp

                )
            }
        }
    }
}