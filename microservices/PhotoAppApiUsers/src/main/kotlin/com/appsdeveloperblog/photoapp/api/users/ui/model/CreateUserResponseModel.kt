package com.appsdeveloperblog.photoapp.api.users.ui.model

data class CreateUserResponseModel(
        private var firstName:String = "",
        private var lastName:String = "",
        private var email:String = "",
        private var userId:String = ""

) {

    //Getters
    fun getFirstName():String { return firstName }
    fun getLastName():String { return lastName }
    fun getEmail():String { return email }
    fun getUserId():String { return userId }

    //Setters
    fun setFirstName(firstName:String) { this.firstName = firstName }
    fun setLastName(lastName:String) { this.lastName = lastName }
    fun setEmail(email:String) { this.email = email }
    fun setUserId(id:String) { this.userId = id }

}