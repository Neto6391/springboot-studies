package com.neto6391.loginapp.data.model

import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id:Long? = null,

        private var name:String? = null,

        @ManyToMany(mappedBy = "roles")
        private var users: Set<User>? = null
) {

    fun getId():Long? {
        return id
    }

    fun setId(id:Long) {
        this.id = id
    }

    fun getName():String? {
        return name
    }

    fun setName(name:String) {
        this.name = name
    }

    fun getUsers():Set<User>? {
        return users
    }

    fun setUsers(users:Set<User>) {
        this.users = users
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Role) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (users != other.users) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (users?.hashCode() ?: 0)
        return result
    }


}