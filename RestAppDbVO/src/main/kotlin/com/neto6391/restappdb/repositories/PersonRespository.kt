package com.neto6391.restappdb.repositories

import com.neto6391.restappdb.data.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PersonRespository : JpaRepository<Person, Long> {
    //UPDATE DATA
    @Modifying
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
    fun disablePerson(@Param("id") id:Long)
}