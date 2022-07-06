package com.example.cryptocoins.ui.theme.Coin

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cryptocoins.util.Validar


@SuppressLint("UnrememberedMutableState,UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegistroCoinScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {

    var errordes by remember {
        mutableStateOf(false)
    }
    var errorval by remember {
        mutableStateOf(false)
    }
    val contexto = LocalContext.current

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
                            navHostController.navigate("CoinScreen")
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
        }
    ) {

        Column(Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = viewModel._description,
                onValueChange = { viewModel._description = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Moneda") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyBitcoin,
                        contentDescription = null
                    )
                },
                isError = errordes

            )
            Validar(error = errordes, text = "Ingrese una Moneda")
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = viewModel._valor,
                onValueChange = { viewModel._valor = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Precio") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = errorval
            )
            Validar(error = errorval, text = "Ingrese un Precio")
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = viewModel._image,
                onValueChange = { viewModel._image = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "URL de Imagen") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = {
                    errordes = viewModel._description.isBlank()
                    errorval = viewModel._valor.isBlank()
                    if (!errordes && !errorval) {
                        if(isNumeric(viewModel._valor) == false){
                            Toast.makeText(
                                contexto,
                                "El precio esta mal ingresado",
                                Toast.LENGTH_LONG
                            ).show()
                        }else{
                            if (viewModel._valor.toDouble() > 0) {
                                viewModel.Post()
                                Toast.makeText(
                                    contexto,
                                    "La moneda se guardó correctamente",
                                    Toast.LENGTH_LONG
                                ).show()
                                viewModel._description = ""
                                viewModel._valor = 0.00.toString()
                                viewModel._image = ""
                                // navHostController.navigate("")
                            } else {
                                Toast.makeText(
                                    contexto,
                                    "El precio no puede ser menor o igual a cero",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }

                },

                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onSecondary,
                    contentColor = MaterialTheme.colors.onPrimary,
                ),
                shape = CutCornerShape(6.dp),

                ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(20.dp))
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
//validar si es numero o no
fun isNumeric(str: String): Boolean {
    return str.matches("-?\\d+(\\.\\d+)?".toRegex())
}