package com.codemen.loginapi.View

import com.codemen.loginapi.Model.User

interface LogInView:BaseView {

    fun showLoading()
    fun hideLoading()
    fun validate():Boolean
    fun gotoMain(user: User)
    fun showMessageError(message:String)
    fun getUsernameField():String
    fun getPasswordField():String
}