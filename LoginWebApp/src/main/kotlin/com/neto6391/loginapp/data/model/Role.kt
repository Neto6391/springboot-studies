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
}