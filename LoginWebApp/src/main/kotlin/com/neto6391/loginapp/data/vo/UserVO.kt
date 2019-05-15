package com.neto6391.loginapp.data.vo

import com.neto6391.loginapp.data.model.Role

data class UserVO(

    private var id:Long = 0L,

    private var username:String = "",
    private var password:String = "",

    @Transient
    private var passwordConfirm:String = "",

    private var roles:MutableSet<HashSet<Role>> = HashSet()
) {
    fun setId(id:Long) {
        this.id = id
    }

    fun setUsername(username:String) {
        this.username = username
    }

    fun setPassword(password:String) {
        this.password = password
    }

    fun setPasswordConfirm(passwordConfirm:String) {
        this.passwordConfirm = passwordConfirm
    }

    fun setRoles(roles:HashSet<Role>) {
        this.roles.add(roles)
    }

    fun getId():Long {
        return id
    }

    fun getUsername():String {
        return username
    }

    fun getPassword():String {
        return password
    }

    fun getPasswordConfirm():String {
        return passwordConfirm
    }

    fun getRoles():MutableSet<HashSet<Role>> {
        return roles
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserVO) return false

        if (id != other.id) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (passwordConfirm != other.passwordConfirm) return false
        if (roles != other.roles) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + passwordConfirm.hashCode()
        result = 31 * result + roles.hashCode()
        return result
    }


}