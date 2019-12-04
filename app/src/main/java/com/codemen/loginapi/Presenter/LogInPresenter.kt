package com.codemen.loginapi.Presenter

import com.codemen.loginapi.Data.response.response.UserDataMapper
import com.codemen.loginapi.LoginActivity
import com.codemen.loginapi.Model.User
import com.codemen.loginapi.Model.interactor.LogInCallback
import com.codemen.loginapi.Model.interactor.LogInInteractor
import com.codemen.loginapi.View.LogInView

class LogInPresenter:Presenter<LogInView>, LogInCallback {

    private var logInView: LogInView?=null
    private var logInInteractor:LogInInteractor?=null


    fun logIn(){
        if(logInView!!.validate())
        {
            logInView!!.showLoading()
            logInInteractor!!.logIn(logInView!!.getUsernameField(),logInView!!.getPasswordField(),this)
        }
    }

    override fun onLogInSuccess(obj: Any) {
        logInView!!.hideLoading()
        var user:User = obj as User
        logInView!!.gotoMain(user)

    }

    override fun onLogInError(obj: Any) {
        logInView!!.hideLoading()
        logInView!!.showMessageError(obj as String)
    }


    override fun addView(view: LoginActivity) {
        logInView= view
        logInInteractor= LogInInteractor(UserDataMapper())
    }

    override fun removeView() {
        logInView=null
    }
}