package com.neto6391.restappdb.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import com.google.common.collect.ImmutableList
import org.springframework.hateoas.ResourceSupport
import java.io.Serializable

@JsonPropertyOrder("id", "first_name", "last_name", "address", "gender", "enabled")
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
    var enabled:Boolean = true

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersonVO) return false
        if (!super.equals(other)) return false

        if (key != other.key) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (gender != other.gender) return false
        if (enabled != other.enabled) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + enabled.hashCode()
        return result
    }


}
