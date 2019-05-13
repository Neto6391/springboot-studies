package com.neto6391.restappdb.security

import java.io.Serializable

class AccountCredentialsVO : Serializable {

    var username:String = ""
    var password:String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AccountCredentialsVO) return false

        if (username != other.username) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }


}