package com.neto6391.restappdb.data.model

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name="books")
class Book : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //HIBERNATE GENERATES ID
    var id:Long = 0

    @Lob
    @Column(nullable = true)
    var author:String = ""

    @Column(name = "launch_date", nullable = false, columnDefinition = "DATETIME(6)")
    var launchDate:Date = Date()

    @Column(nullable = false, precision = 65, scale = 2)
    var price:Double = 0.0

    @Lob
    @Column(nullable = true)
    var title:String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false
        if (author != other.author) return false
        if (launchDate != other.launchDate) return false
        if (price != other.price) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + launchDate.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }


}