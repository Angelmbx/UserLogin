package com.example.loginusuario.UI.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loginusuario.UI.Stateholders.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun LoginScreen(){
   
    val LoginViewModel : LoginViewModel = viewModel()

    if (LoginViewModel.loginScreenview) {


        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Identifícate") },
                    actions = {
                        IconButton(
                            onClick = { /*TODO*/ },
                            enabled = false
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Arrow back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->


            if (LoginViewModel.loginScreenview) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f), text = "Usuario"
                        )
                        TextField(modifier = Modifier.weight(2f),
                            value = LoginViewModel.datosUsuario,
                            onValueChange = { LoginViewModel.onUsuarioChange(it) })
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Contraseña"
                        )
                        TextField(modifier = Modifier.weight(2f),
                            value = LoginViewModel.datosPassword,
                            onValueChange = { LoginViewModel.onPasswordChange(it) })
                    }
                    Button(modifier = Modifier
                        .padding(15.dp),
                        onClick = { LoginViewModel.changeBooleanOnClick() }
                    ) {
                        Text(text = "Log in")
                    }
                }
            } else {
                if (LoginViewModel.datosUsuario == "angel" && LoginViewModel.datosPassword == "password")
                    LoggedScreen(paddingValues)
                else
                    LoginErrorScreen(paddingValues)

            }
        }
    }
else{
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Inicio de sesión") },
                    actions = {
                        IconButton(
                            enabled = true,
                            onClick = {LoginViewModel.changeBooleanOnClick()
                                        LoginViewModel.resetDatos()}

                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Arrow back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->


            if (LoginViewModel.loginScreenview) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f), text = "Usuario"
                        )
                        TextField(modifier = Modifier.weight(2f),
                            value = LoginViewModel.datosUsuario,
                            onValueChange = { LoginViewModel.onUsuarioChange(it) })
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp)
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Contraseña"
                        )
                        TextField(modifier = Modifier.weight(2f),
                            value = LoginViewModel.datosPassword,
                            onValueChange = { LoginViewModel.onPasswordChange(it) })
                    }
                    Button(modifier = Modifier
                        .padding(15.dp),
                        onClick = { LoginViewModel.changeBooleanOnClick() }
                    ) {
                        Text(text = "Log in")
                    }
                }
            } else {
                if (LoginViewModel.datosUsuario == "angel" && LoginViewModel.datosPassword == "password")
                    LoggedScreen(paddingValues)
                else
                    LoginErrorScreen(paddingValues)

            }
        }
    }

    }


