package com.appsdeveloperblog.photoapp.api.users.ui.model

import java.io.Serializable
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateUserRequestModel(
        @NotNull(message = "First Name cannot be null")
        @Size(min = 3, message = "First name must no be less than three characters")
        private var firstName:String = "",

        @NotNull(message = "Last Name Name cannot be null")
        @Size(min = 3, message = "Last Name must no be less than three characters")
        private var lastName:String = "",

        @NotNull(message = "Password cannot be null")
        @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters and less than 16 characters")
        private var password:String = "",

        @NotNull(message = "Email cannot be null")
        @Email
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