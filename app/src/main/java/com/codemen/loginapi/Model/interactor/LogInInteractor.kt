package com.codemen.loginapi.Model.interactor

import com.codemen.loginapi.Data.response.response.ApiClient
import com.codemen.loginapi.Data.response.response.LogInRaw
import com.codemen.loginapi.Data.response.response.LoginResponse
import com.codemen.loginapi.Data.response.response.UserDataMapper
import com.codemen.loginapi.Model.User
import retrofit2.Callback
import retrofit2.Response

class LogInInteractor {

    var userDataMapper:UserDataMapper?=null

    constructor(mapper: UserDataMapper){
        this.userDataMapper= mapper
    }

    fun logIn(usuario:String,contrasena:String, logInCallback: LogInCallback){

        var logInRaw: LogInRaw = LogInRaw(usuario,contrasena)

        ApiClient.getMyApiClient().logIn(logInRaw,object: Callback<LoginResponse> {
            fun success(logInResponse: LoginResponse?, response: Response?) {
                if(LoginResponse!!.isSuccess()){
                    var user: User = userDataMapper!!.transformResponse(LoginResponse())
                    logInCallback.onLogInSuccess(user)
                }else{
                    logInCallback.onLogInError("an error occurred...")
                }
            }


        })

    }
}