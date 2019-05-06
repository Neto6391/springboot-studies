package com.neto6391.restappdb.converter.custom

import com.neto6391.restappdb.data.model.Person
import com.neto6391.restappdb.data.vo.v2.PersonVOV2
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonConverter {

    fun convertEntityToVo(person: Person): PersonVOV2 {
        val vo = PersonVOV2()
        vo.id = person.id
        vo.address = person.address
        //This is to see if you eat data in db, so I no generate this column on db
        vo.birthDay = Date()
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.gender = person.gender
        return vo
    }

    fun convertEntityVoToEntity(person: PersonVOV2): Person {
        val entity = Person()
        entity.id = person.id
        entity.address = person.address
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.gender = person.gender
        return entity
    }

}