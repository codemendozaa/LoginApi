package com.codemen.loginapi.Presenter

import com.codemen.loginapi.LoginActivity

interface Presenter<T> {

    fun addView(view: LoginActivity)
    fun removeView()

}