package com.appsdeveloperblog.photoapp.api.users.shared

import java.io.Serializable

data class UserDto(
        private var firstName:String = "",
        private var lastName:String = "",
        private var email:String = "",
        private var password:String = "",
        private var userId:String,
        private var encryptedPassword: String
) : Serializable {
    //Getters
    fun getFirstName():String { return firstName }
    fun getLastName():String { return lastName}
    fun getPassword():String { return password }
    fun getEmail():String { return email }
    fun getId():String { return userId}
    fun getEncriptedPassword():String { return encryptedPassword }

    //Setters
    fun setFirstName(firstName:String) { this.firstName = firstName }
    fun setLastName(lastName:String) { this.lastName = lastName }
    fun setPassword(password:String) { this.password = password }
    fun setEmail(email:String) { this.email = email }
    fun setId(id:String) { this.userId = id }
    fun setEncriptedPassword(encryptedPassword: String) { this.encryptedPassword = encryptedPassword }
}