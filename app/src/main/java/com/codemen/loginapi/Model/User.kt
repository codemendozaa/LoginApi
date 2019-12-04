package com.codemen.loginapi.Model

import android.os.Parcel
import android.os.Parcelable

data class User(
    val usuario: String?,
    val contrasena: String?,
    val versionDispositivo: String?,
    val nombreDispositivo: String?,
    val idTipoDispositivo:Int):  Parcelable {

    constructor(source: Parcel) : this(
        source.readString(), source.readString(),
        source.readString(), source.readString(),source.readInt()
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        //throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        dest?.writeString(this.usuario)
        dest?.writeString(this.contrasena)
        dest?.writeString(this.versionDispositivo)
        dest?.writeString(this.nombreDispositivo)

    }

    override fun describeContents(): Int {
        //throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        return 0
    }


    companion object {
        @JvmField
        final val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User {
                return User(source)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }
}
