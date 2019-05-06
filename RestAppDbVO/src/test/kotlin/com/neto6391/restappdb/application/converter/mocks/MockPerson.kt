package com.neto6391.restappdb.application.converter.mocks

import com.neto6391.restappdb.data.model.Person
import com.neto6391.restappdb.data.vo.v1.PersonVO

class MockPerson{

    fun mockEntity():Person {
        return mockEntity(0)
    }

    fun mockVO(): PersonVO {
        return mockVO(0)
    }

    fun mockEntityList():List<Person> {
        val persons:MutableList<Person> = mutableListOf()
        for(i in 0..13) {
            persons.add(mockEntity(i))
        }
        return persons
    }

    fun mockVOList():List<PersonVO> {
        val persons:MutableList<PersonVO> = mutableListOf()
        for(i in 0..13) {
            persons.add(mockVO(i))
        }
        return persons
    }

    private fun mockEntity(number: Int): Person {
        var person: Person = Person()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 === 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"
        return person
    }

    private fun mockVO(number: Int): PersonVO {
        var person: PersonVO = PersonVO()
        person.address = "Address Test$number"
        person.firstName = "First Name Test$number"
        person.gender = if (number % 2 === 0) "Male" else "Female"
        person.id = number.toLong()
        person.lastName = "Last Name Test$number"
        return person
    }
}