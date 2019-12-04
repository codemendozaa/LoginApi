package com.codemen.loginapi.Data.response.response

import com.codemen.loginapi.Data.response.UserEntity
import com.codemen.loginapi.Model.User

class UserDataMapper {
    fun transform(userEntity: UserEntity):User{
        var user = User("","","DEV","DEV",2)
        if(userEntity==null)return user

        user= User(userEntity.usuario,userEntity.contrasena,userEntity.versionDispositivo,
            userEntity.nombreDispositivo,userEntity.idTipoDispositivo)
        return user
    }

    fun transformResponse(loginResponse:LoginResponse):User{
        var user: User = User("","","DEV","DEV",2)
        if(loginResponse==null) return  user

        user= transform(loginResponse.data!!)
        return user
    }
}