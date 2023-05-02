package com.example.loginusuario.UI.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun LoginScreen(){
   
    var datosUsuario by rememberSaveable { mutableStateOf("") }
    var datosPassword by rememberSaveable { mutableStateOf("") }
    var loginScreenview by rememberSaveable { mutableStateOf(true) }
    
    Scaffold (
        topBar = {
            TopAppBar(
                title ={ Text(text = "Identifícate") }
            )}
            ) { paddingValues ->


        if(loginScreenview) {
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
                        value = datosUsuario, onValueChange = { datosUsuario = it })
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
                        value = datosPassword, onValueChange = { datosPassword = it })
                }
                Button(modifier = Modifier
                    .padding(15.dp),
                    onClick = { loginScreenview = false }
                ) {
                    Text(text = "Log in")
                }
            }
        }
        else {
            LoggedScreen(paddingValues)
        }
    }


}