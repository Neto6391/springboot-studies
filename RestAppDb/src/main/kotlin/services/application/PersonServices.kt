package services.application

import exception.application.ResourceNotFoundException
import models.aplication.Person
import org.springframework.beans.factory.annotation.Autowired
import repository.application.PersonRespository
import org.springframework.stereotype.Service

@Service
class PersonServices {

    @Autowired
    lateinit var repository:PersonRespository

    fun create(person:Person):Person {
        return repository.save(person)
    }


    fun findById(id:Long):Person {
        return repository.findById(id).orElseThrow(fun(){
            ResourceNotFoundException("No records found for this ID")
        })
    }

    fun findAll():List<Person> {
        val persons:MutableList<Person> = mutableListOf<Person>()
        for (i in 0..8) {
            var person:Person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun update(person:Person):Person {
        return person
    }

    fun delete(id:String) {

    }

    private fun mockPerson(i:Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Last name $i"
        person.address = "Some address Brazil $i"
        person.gender = "M/F"
        return person
    }


}