package com.neto6391.restappdb.repositories

import com.neto6391.restappdb.data.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRespository : JpaRepository<Person, Long> {}