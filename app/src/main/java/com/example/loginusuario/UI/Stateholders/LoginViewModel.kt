package com.example.loginusuario.UI.Stateholders

import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

   private var _datosUsuario by  mutableStateOf("")
    val datosUsuario get() = _datosUsuario

   private var _datosPassword by  mutableStateOf("")
    val datosPassword get() = _datosPassword

    private var _loginScreenview by  mutableStateOf(true)
    val loginScreenview get() = _loginScreenview

    fun onUsuarioChange(newName: String){
        _datosUsuario = newName
    }

    fun onPasswordChange(newName: String){
        _datosPassword = newName
    }

    fun changeBooleanOnClick(){
        _loginScreenview = !_loginScreenview
    }

}