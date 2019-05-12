package com.neto6391.restappdb.repositories

import com.neto6391.restappdb.data.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRespository : JpaRepository<User, Long> {

    //JPQL IMPLEMENTATION
    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    fun findByUsername(@Param("userName") userName:String):User

}