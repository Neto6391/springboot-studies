package com.neto6391.restappdb.data.vo.v2

import java.io.Serializable
import java.util.*

class PersonVOV2(var id:Long = 0,
                 var firstName:String = "",
                 var lastName:String = "",
                 var address:String = "",
                 var gender:String = "",
                 var birthDay:Date = Date()
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PersonVOV2

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (gender != other.gender) return false
        if (birthDay != other.birthDay) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + birthDay.hashCode()
        return result
    }
}