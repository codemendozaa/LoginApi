package com.codemen.loginapi.Data.response.response

import com.codemen.loginapi.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.security.auth.callback.Callback

class ApiClient {

    companion object {
        private var servicesApiInterface:ServicesApiInterface?=null

        fun  getMyApiClient(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(" http://181.57.145.20:8081/Security")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


    }

    interface ServicesApiInterface{
        @Headers("Content-Type: application/json")
        @POST("/api/Autenticacion/Login")
        fun logIn(@Body raw:LogInRaw, callback: Callback<LoginResponse>)
    }
}