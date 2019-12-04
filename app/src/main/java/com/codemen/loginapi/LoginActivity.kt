package com.codemen.loginapi

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.codemen.loginapi.Model.User
import com.codemen.loginapi.Presenter.LogInPresenter
import java.time.temporal.TemporalAdjusters.next

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter= LogInPresenter()
        loginPresenter!!.addView(this)
    }

    @BindView(R.id.btnLogIn)
    lateinit  var btnLogIn: Button

    @BindView(R.id.eteEmail)
    lateinit var eteEmail: EditText

    @BindView(R.id.etePassword)
    lateinit var etePassword: EditText


    lateinit var vLoading: View

    var loginPresenter: LogInPresenter?=null
    var username:String?=null
    var password:String?=null





    private fun ui() {
        btnLogIn!!.setOnClickListener{

            logIn()
        }
    }

    fun showLoading() {
        vLoading!!.setVisibility(View.VISIBLE)
    }

    fun hideLoading() {
        vLoading!!.setVisibility(View.GONE)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun gotoMain(user: User) {
        val bundle: Bundle = Bundle()
        bundle.putParcelable("ENTITY",user)
        next(bundle,MainActivity::class.java,false)
    }


    private fun logIn() {
        loginPresenter!!.logIn()
    }

    fun validate(): Boolean {
        username= eteEmail!!.text.toString().trim()
        password=etePassword!!.text.toString().trim()
        eteEmail!!.setError(null)
        etePassword!!.setError(null)

        if(username!!.isEmpty()){
            eteEmail!!.setError(getString(R.string.msg_ingresar));
            return false
        }

        return true
    }

    fun getUsernameField(): String {
        return this.username!!
    }

    fun getPasswordField(): String {
        return this.password!!
    }

    fun getContext(): Context {
        return this
    }


}

annotation class BindView(val value: Any)
