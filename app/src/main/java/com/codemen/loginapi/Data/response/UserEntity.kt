package com.codemen.loginapi.Data.response

data class UserEntity (
    val usuario:String , val contrasena:String,
    val versionDispositivo:String, val nombreDispositivo:String,
    val idTipoDispositivo:Int
)