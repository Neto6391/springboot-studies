package services.application

import models.aplication.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class PersonServices {

    //ID_COUNTER DATABASE
    private val counter = AtomicLong()

    fun create(person:Person):Person {
        return person
    }

    fun update(person:Person):Person {
        return person
    }

    fun delete(id:String) {

    }

    fun findById(id:String):Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Neto"
        person.lastName = "6391"
        person.address = "City - State - Country"
        person.gender = "Male"
        return person
    }

    fun findAll():List<Person> {
        val persons:MutableList<Person> = mutableListOf<Person>()
        for (i in 0..8) {
            var person:Person = mockPerson(i)
            persons.add(person)
        }
        return persons
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