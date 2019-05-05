package com.neto6391.restappdb.services

import com.neto6391.restappdb.exceptions.ResourceNotFoundException
import com.neto6391.restappdb.data.model.Person
import org.springframework.beans.factory.annotation.Autowired
import com.neto6391.restappdb.repositories.PersonRespository
import org.springframework.stereotype.Service

@Service
class PersonServices(private val repository: PersonRespository) {

    fun create(person: Person): Person {
        return repository.save(person)
    }

    fun findAll():List<Person> {
        return repository.findAll()
    }

    fun findById(id:Long): Person {
        return repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }
    }


    fun update(person: Person): Person {
        var entity: Person = findById(person.id)
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id:Long) {
        var entity: Person = findById(id)
        repository.delete(entity)
    }
}