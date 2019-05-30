package com.appsdeveloperblog.photoapp.api.users.data

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="users")
data class UserEntity(
        @Id
        @GeneratedValue
        private var id:Long = 0L,

        @Column(nullable = false, length=50)
        private var firstName:String = "",

        @Column(nullable = false, length=50)
        private var lastName:String = "",

        @Column(nullable = false, length=120, unique = true)
        private var email:String = "",

        @Column(nullable = false, unique = true)
        private var userId:String = "",

        @Column(nullable = false, unique = true)
        private var encryptedPassword: String = ""
) : Serializable {

    //Getters
    fun getId():Long { return id}
    fun getFirstName():String { return firstName }
    fun getLastName():String { return lastName}
    fun getEmail():String { return email }
    fun getUserId():String { return userId}
    fun getEncriptedPassword():String { return encryptedPassword }

    //Setters
    fun setId(id:Long) { this.id = id }
    fun setFirstName(firstName:String) { this.firstName = firstName }
    fun setLastName(lastName:String) { this.lastName = lastName }
    fun setEmail(email:String) { this.email = email }
    fun setUserId(id:String) { this.userId = id }
    fun setEncriptedPassword(encryptedPassword: String) { this.encryptedPassword = encryptedPassword }
}