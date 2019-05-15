package com.neto6391.loginapp.data.model

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private var id:Long? = null,


       private var username:String? = null,
       private var password:String? = null,

       @Transient
       private var passwordConfirm:String? = null,

       @ManyToMany
       private var roles: Set<Role>? = null

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

    fun setRoles(roles:Set<Role>) {
        this.roles = roles
    }

    fun getId():Long? {
        return id
    }

    fun getUsername():String? {
        return username
    }

    fun getPassword():String? {
        return password
    }

    fun getPasswordConfirm():String? {
        return passwordConfirm
    }

    fun getRoles():Set<Role>? {
        return roles
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (passwordConfirm != other.passwordConfirm) return false
        if (roles != other.roles) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id!!.hashCode()
        result = 31 * result + username!!.hashCode()
        result = 31 * result + password!!.hashCode()
        result = 31 * result + passwordConfirm!!.hashCode()
        result = 31 * result + roles!!.hashCode()
        return result
    }
}