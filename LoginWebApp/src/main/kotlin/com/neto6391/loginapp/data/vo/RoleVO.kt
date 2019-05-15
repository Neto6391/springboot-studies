package com.neto6391.loginapp.data.vo

import com.neto6391.loginapp.data.model.User

data class RoleVO (
        private var id:Long = 0L,
        private var name:String = "",
        private var users:MutableSet<HashSet<User>> = HashSet()
) {
    fun getId():Long {
        return id
    }

    fun setId(id:Long) {
        this.id = id
    }

    fun getName():String {
        return name
    }

    fun setName(name:String) {
        this.name = name
    }

    fun getUsers():MutableSet<HashSet<User>> {
        return users
    }

    fun setUsers(users:HashSet<User>) {
        this.users.add(users)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RoleVO) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (users != other.users) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + users.hashCode()
        return result
    }


}