package repository.application

import models.aplication.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRespository : JpaRepository<Person, Long> {

}