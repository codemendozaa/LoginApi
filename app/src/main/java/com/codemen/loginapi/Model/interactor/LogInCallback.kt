package com.codemen.loginapi.Model.interactor

interface LogInCallback {

    fun onLogInSuccess(obj:Any) {}
    fun onLogInError(obj:Any) {}
}