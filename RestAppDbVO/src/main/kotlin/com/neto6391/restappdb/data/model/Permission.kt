package com.neto6391.restappdb.data.model

import org.springframework.security.core.GrantedAuthority
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "permission")
open class Permission() : GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id:Long = 0L

    @Column(name = "description")
    var description:String = ""

    override fun getAuthority(): String {
        return this.description
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Permission) return false

        if (id != other.id) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }


}