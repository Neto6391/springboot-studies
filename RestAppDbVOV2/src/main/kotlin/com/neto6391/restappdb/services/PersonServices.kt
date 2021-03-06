package com.neto6391.restappdb.services

import com.neto6391.restappdb.converter.AdapterConverter
import com.neto6391.restappdb.converter.custom.PersonConverter
import com.neto6391.restappdb.exceptions.ResourceNotFoundException
import com.neto6391.restappdb.data.model.Person
import com.neto6391.restappdb.data.vo.v1.PersonVO
import com.neto6391.restappdb.data.vo.v2.PersonVOV2
import com.neto6391.restappdb.repositories.PersonRespository
import org.springframework.stereotype.Service

@Service
class PersonServices(
        private val repository: PersonRespository,
        private val converter: PersonConverter
) {

    fun create(person: PersonVO): PersonVO {
        val entity = AdapterConverter.parseObject(person, Person::class.java)
        val vo = AdapterConverter.parseObject(repository.save(entity), PersonVO::class.java)
        return vo
    }

    //The idea of keep this Endpoint in V2 up until time validity is over
    fun createV2(person: PersonVOV2): PersonVOV2 {
        val entity = converter.convertEntityVoToEntity(person)
        val vo = converter.convertEntityToVo(repository.save(entity))
        return vo
    }

    fun findAll():List<PersonVO> {
        return AdapterConverter.parseListObjects(repository.findAll(), PersonVO::class.java)
    }

    fun findById(id:Long): PersonVO {
        val entity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }
        return AdapterConverter.parseObject(entity, PersonVO::class.java)
    }


    fun update(person: PersonVO): PersonVO {
        var entity = repository.findById(person.id).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        val vo = AdapterConverter.parseObject(repository.save(entity), PersonVO::class.java)
        return vo
    }

    fun delete(id:Long) {
        val entity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }
        repository.delete(entity)
    }
}