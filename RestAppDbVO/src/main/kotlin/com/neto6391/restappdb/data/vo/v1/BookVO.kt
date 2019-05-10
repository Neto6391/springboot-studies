package com.neto6391.restappdb.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.ResourceSupport
import java.io.Serializable
import java.util.*

@JsonPropertyOrder("id", "title", "author", "launch_date", "price")
open class BookVO : ResourceSupport(), Serializable {

    @Mapping("id")
    @JsonProperty("id")
    var key:Long = 0

    var author:String = ""

    @JsonProperty("launch_date")
    var launchDate:Date = Date()
    var price:Double = 0.0
    var title:String = ""


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BookVO) return false

        if (key != other.key) return false
        if (author != other.author) return false
        if (launchDate != other.launchDate) return false
        if (price != other.price) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + launchDate.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }


}