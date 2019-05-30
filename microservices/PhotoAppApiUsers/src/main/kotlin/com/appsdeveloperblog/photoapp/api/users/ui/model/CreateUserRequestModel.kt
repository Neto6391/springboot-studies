package com.appsdeveloperblog.photoapp.api.users.ui.model

import java.io.Serializable

data class CreateUserRequestModel(
        private var firstName:String = "",
        private var lastName:String = "",
        private var password:String = "",
        private var email:String = ""
) {
    //Getters
    fun getFirstName():String { return firstName }
    fun getLastName():String { return lastName}
    fun getPassword():String { return password }
    fun getEmail():String { return email }

    //Setters
    fun setFirstName(firstName:String) { this.firstName = firstName }
    fun setLastName(lastName:String) { this.lastName = lastName }
    fun setPassword(password:String) { this.password = password }
    fun setEmail(email:String) { this.email = email }
}