package com.neto6391.restappdb.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.ResourceSupport
import java.io.Serializable

@JsonPropertyOrder("id", "first_name", "last_name", "address", "gender")
open class PersonVO : ResourceSupport(), Serializable {

    @Mapping("id")
    @JsonProperty("id")
    var key:Long = 0

    @JsonProperty("first_name")
    var firstName:String = ""

    @JsonProperty("last_name")
    var lastName:String = ""
    var address:String = ""


    var gender:String = ""
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as PersonVO

        if (key != other.key) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (gender != other.gender) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gender.hashCode()
        return result
    }


}